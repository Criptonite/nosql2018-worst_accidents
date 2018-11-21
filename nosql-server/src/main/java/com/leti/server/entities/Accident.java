package com.leti.server.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "accidents")
public class Accident {
    @Id
    String id;
    @Field("code")
    @JsonProperty("code")
    String code;
    @Field("name")
    @JsonProperty("name")
    String region;
    @Field("KartId")
    @JsonProperty("KartId")
    String kartId;
    @Field("date")
    @JsonProperty("date")
    String date;
    @Field("time")
    @JsonProperty("time")
    String time;
    @Field("district")
    @JsonProperty("district")
    String district;
    @Field("type")
    @JsonProperty("type")
    String type;
    @Field("ts_count")
    @JsonProperty("ts_count")
    int tsCount;
    @Field("uch_count")
    @JsonProperty("uch_count")
    int uchCount;
    @Field("dtp_info")
    @JsonProperty("dtp_info")
    DtpInfo dtpInfo;

}
