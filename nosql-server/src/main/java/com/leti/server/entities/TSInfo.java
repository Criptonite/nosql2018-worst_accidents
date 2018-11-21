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
public class TSInfo {
    @Field("type")
    @JsonProperty("type")
    String type;
    @Field("marka")
    @JsonProperty("marka")
    String mark;
    @Field("model")
    @JsonProperty("model")
    String model;
    @Field("g_v")
    @JsonProperty("g_v")
    int yearOfIssue;
    @Field("color")
    @JsonProperty("color")
    String color;
    @Field("uch_info")
    @JsonProperty("uch_info")
    List<UchInfo> uchInfo;
}
