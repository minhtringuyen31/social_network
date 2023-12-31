package com.example.server.controllers;

import com.example.server.models.UserModel;
import com.example.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> findAll(){
        List<UserModel> listUsers = service.findAll();
        System.out.println("hereeeeeee: "+ listUsers);
        return ResponseEntity.ok(listUsers);
    }

    @GetMapping
    public ResponseEntity<Optional<UserModel>> findOne (@RequestParam("id") int id){
        Optional<UserModel> user = service.findOne(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public UserModel createNewUser (@RequestBody UserModel user){
        return service.createNewUser(user);
    }
}
