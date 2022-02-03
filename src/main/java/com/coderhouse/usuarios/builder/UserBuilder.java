package com.coderhouse.usuarios.builder;

import com.coderhouse.usuarios.model.User;
import com.coderhouse.usuarios.model.UserFactory;
import com.coderhouse.usuarios.model.request.UserRequest;
import com.coderhouse.usuarios.model.response.UserResponse;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class UserBuilder {

    private static final UserFactory userFactory = new UserFactory();

    public static User requestToDocument(UserRequest user) {
        var entity = userFactory.createUser(user.getType(), user.getName());
        return userFactory.createUser(user.getType(), user.getName());
    }

    public static UserResponse documentToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .type(user.getType())
                .name(user.getName())
                .creationDate(user.getCreationDate())
                .modificationDate(user.getModificationDate())
                .build();
    }
}