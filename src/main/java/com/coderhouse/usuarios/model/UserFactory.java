package com.coderhouse.usuarios.model;

import com.coderhouse.usuarios.model.types.Admin;
import com.coderhouse.usuarios.model.types.Client;
import com.coderhouse.usuarios.model.types.Editor;
import lombok.Data;


@Data
public class UserFactory {
    public User createUser(String type, String name){
        switch (type){
            case "admin":
                return new Admin(type,name);
            case "editor":
                return  new Editor(type,name);
            case "client":
                return new Client(type,name);

            default:
                return null;
        }
    }
}
