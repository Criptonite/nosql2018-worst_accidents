package com.leti.server.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "types")
public class Type {
    @Id
    String id;
    String typeName;

    public Type(String type) {
        this.typeName = type;
    }
}
