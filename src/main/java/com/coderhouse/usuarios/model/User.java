package com.coderhouse.usuarios.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("usuarios")
public abstract class User {

    @Id
    private String id;
    private String type;
    private String name;

    public User(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
