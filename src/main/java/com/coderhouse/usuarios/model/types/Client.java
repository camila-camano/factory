package com.coderhouse.usuarios.model.types;

import com.coderhouse.usuarios.model.User;
import lombok.Builder;

public class Client extends User {

    public Client(String type, String name){
        super(type,name);
    }



}
