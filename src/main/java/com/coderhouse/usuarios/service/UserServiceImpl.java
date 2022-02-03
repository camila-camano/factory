package com.coderhouse.usuarios.service;

import com.coderhouse.usuarios.builder.UserBuilder;
import com.coderhouse.usuarios.cache.CacheClient;
import com.coderhouse.usuarios.model.User;
import com.coderhouse.usuarios.model.UserFactory;
import com.coderhouse.usuarios.model.request.UserRequest;
import com.coderhouse.usuarios.model.response.UserResponse;
import com.coderhouse.usuarios.model.types.Admin;
import com.coderhouse.usuarios.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{


    private  final UserRepository repository;
    private final UserFactory userFactory = new UserFactory();

    List<User> users = new ArrayList<>();

    private final CacheClient<User> cache;

    @Autowired
    private MongoTemplate template;

    @Override
    public User create(String type, String name){

        var entity = userFactory.createUser(type,name);
        try {
            var entitySaved = repository.save(entity);
            users.add(entity);
            return saveUserInCache(entity);

        } catch (JsonProcessingException e) {
            log.error("Error convirtiendo user a string", e);
        }
        return entity;
    }

    private User saveUserInCache(User user) throws JsonProcessingException {
        return cache.save(user.toString(), user);
    }

    @Override
    public User getByName(String name){

        var entity = cache.recover(name, User.class);
        if (entity == null){
            var entityRepo = repository.findByName(name);
            cache.saveCache(entityRepo.toString(),entityRepo);
            return entityRepo;
        }else{
            return entity;
        }

    }

    @Override
    public List<User> getAll() {
        return null;
    }


    @Override
    public UserResponse createResponse(UserRequest userRequest){
         var document = UserBuilder.requestToDocument(userRequest);

         // Guardo en mongo y cache
         repository.save(document);
         cache.saveCache(document.toString(), document);

         return UserBuilder.documentToResponse(document);
    }

}
