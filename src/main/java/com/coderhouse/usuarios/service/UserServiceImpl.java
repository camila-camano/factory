package com.coderhouse.usuarios.service;

import com.coderhouse.usuarios.model.User;
import com.coderhouse.usuarios.model.UserFactory;
import com.coderhouse.usuarios.model.types.Admin;
import com.coderhouse.usuarios.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{


    private  final UserRepository repository;
    private final UserFactory userFactory = new UserFactory();

    List<User> users = new ArrayList<>();

    @Override
    public String create(String type, String name){
        var entity = userFactory.createUser(type,name);
        var entitySaved = repository.save(entity);
        users.add(entity);

        return entitySaved.toString();
    }

    @Override
    public User getByName(String name){
        for(User u: users){
            if (Objects.equals(u.getName(), name)){
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll(){
        return users;
    }

}
