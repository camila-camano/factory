package com.coderhouse.usuarios.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document("usuarios")
public abstract class User {

    @Id
    private String id;
    private String type;
    private String name;


    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;

    public User(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
