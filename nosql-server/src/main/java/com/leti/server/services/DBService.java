package com.leti.server.services;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DBService {

    final private static String DB_NAME = "accidents";
    @Autowired
    public DBService() {
    }

    public String makeBackUp(Path exportPath) {
        try {
            if (exportPath.toFile().exists()) {
                FileUtils.deleteDirectory(exportPath.toFile());
            }
            Process exportProcess = Runtime.getRuntime().exec("mongodump --db " + DB_NAME +" --out " + exportPath);
            exportProcess.waitFor();
            File dumpZipFile = new File(exportPath.toString() + "/" + DB_NAME +"_dump.zip");
            ZipUtil.pack(Paths.get(exportPath.toString() + "/" + DB_NAME).toFile(), dumpZipFile);
            return dumpZipFile.getName();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
