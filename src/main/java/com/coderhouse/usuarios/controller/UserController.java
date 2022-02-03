package com.coderhouse.usuarios.controller;

import com.coderhouse.usuarios.model.User;
import com.coderhouse.usuarios.model.request.UserRequest;
import com.coderhouse.usuarios.model.response.UserResponse;
import com.coderhouse.usuarios.model.types.Admin;
import com.coderhouse.usuarios.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @PostMapping("/create")
    public User createUser(@RequestParam String type, String name){
        return service.create(type,name);
    }

    @PostMapping("/createrequest")
    public UserResponse createRequest(@RequestBody UserRequest request){
        return service.createResponse(request);

    }

    @GetMapping("/getbyname")
    public User getAdmins(@RequestParam String name){
        return service.getByName(name);
    }

    @GetMapping("/getall")
    public List<User> getAll(){
        return service.getAll();
    }
}
