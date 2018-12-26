package com.leti.server.controllers;

import com.leti.server.services.DBService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/db")
public class DBController {
    private DBService dbService;
    private ServletContext context;

    final private static Path exportPath = Paths.get("./export");
    @Autowired
    public DBController(ServletContext context, DBService dbService) {
        this.dbService = dbService;
        this.context = context;
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    @ResponseBody
    public String getDumpFileLink(HttpServletRequest request, HttpServletResponse response) {
        String fileName = dbService.makeBackUp(exportPath);
        String link = String.format("%s://%s:%d/db/download/%s", request.getScheme(), request.getServerName(), request.getServerPort(), fileName);
        return "{ \"link\": \" " + link + "\"}";
    }

    @RequestMapping(value = "/download/{fileName}", method = RequestMethod.GET)
    public void getDumpFileLink(HttpServletResponse response, @PathVariable("fileName") String fileName) throws IOException {
        if (fileName != null) {
            try {
                File file = Paths.get(exportPath.toString() + "/" + fileName).toFile();

                if (file.exists()) {
                    String mimeType = context.getMimeType(file.getPath());

                    if (mimeType == null) {
                        mimeType = "application/octet-stream";
                    }

                    response.setContentType(mimeType);
                    response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
                    response.setContentLength((int) file.length());

                    OutputStream os = response.getOutputStream();
                    try (FileInputStream fis = new FileInputStream(file)) {
                        byte[] buffer = new byte[4096];
                        int b = -1;

                        while ((b = fis.read(buffer)) != -1) {
                            os.write(buffer, 0, b);
                        }
                    }
                    os.close();
                    FileUtils.deleteDirectory(exportPath.toFile());
                } else {
                    response.setStatus(404);
                }
            } catch (IOException e) {
                response.setStatus(404);
            }
        } else {
            response.setStatus(404);
        }
    }
}
