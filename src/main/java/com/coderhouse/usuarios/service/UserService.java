package com.coderhouse.usuarios.service;

import com.coderhouse.usuarios.model.User;
import com.coderhouse.usuarios.model.UserFactory;
import com.coderhouse.usuarios.model.types.Admin;
import com.coderhouse.usuarios.model.types.Client;
import com.coderhouse.usuarios.model.types.Editor;

import java.util.List;

public interface UserService {
    String create(String type, String name);

    User getByName(String name);

    List<User> getAll();
}
