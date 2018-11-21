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
public class UchInfo {
    @Field("role")
    @JsonProperty("role")
    String role;
    @Field("NPDD")
    @JsonProperty("NPDD")
    List<String> npdd;
    @Field("gender")
    @JsonProperty("gender")
    String gender;
    @Field("state")
    @JsonProperty("state")
    String state;
}
