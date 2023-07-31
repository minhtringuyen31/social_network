package com.example.server.controllers;

import com.example.server.models.PostModel;
import com.example.server.models.UserModel;
import com.example.server.services.PostService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/post")
public class PostController {
    @Autowired
    private PostService service;

    @PostMapping
    public PostModel createNewPost(@RequestBody PostModel newPost){
        System.out.println(newPost.getUserId());
        return service.createNewPost(newPost);
    }

    @GetMapping
    public List<PostModel> getAll(@RequestParam("userId") int userId){
        return service.getAll(userId);
    }

}
