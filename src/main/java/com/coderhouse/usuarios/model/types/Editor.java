package com.coderhouse.usuarios.model.types;

import com.coderhouse.usuarios.model.User;
import lombok.Builder;

public class Editor extends User {

    public Editor(String type, String name){
        super(type,name);
    }


}
