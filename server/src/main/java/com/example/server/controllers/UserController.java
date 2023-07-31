package com.example.server.controllers;

import com.example.server.models.UserModel;
import com.example.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<UserModel> findAll(){
        List<UserModel> listUsers = service.findAll();
        System.out.println(listUsers.toString());
        return listUsers;
    }

    @GetMapping
    public Optional<UserModel> findOne (@RequestParam("id") int id){
        Optional<UserModel> user = service.findOne(id);
        return user;
    }

    @PostMapping
    public UserModel createNewUser (@RequestBody UserModel user){
        return service.createNewUser(user);
    }
}
