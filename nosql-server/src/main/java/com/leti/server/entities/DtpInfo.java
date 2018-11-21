package com.leti.server.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtpInfo {
    @Field("sdor")
    @JsonProperty("sdor")
    List<String> sdor;
    @Field("ndu")
    @JsonProperty("ndu")
    List<String> ndu;
    @Field("light")
    @JsonProperty("light")
    String light;
    @Field("weater")
    @JsonProperty("weater")
    String weather;
    @Field("longitude")
    @JsonProperty("longitude")
    double longtitude;
    @Field("latitude")
    @JsonProperty("latitude")
    double latitude;
    @Field("ts_info")
    @JsonProperty("ts_info")
    List<TSInfo> tsInfo;
    @Field("uch_info")
    @JsonProperty("uch_info")
    List<UchInfo> uchInfo;
}
