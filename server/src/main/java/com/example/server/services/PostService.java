package com.example.server.services;

import com.example.server.models.PostModel;
import com.example.server.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public PostModel createNewPost(PostModel newPost){
        return repository.save(newPost);
    }
    public List<PostModel> getAll(int userId){
        return repository.getAllByUserId(userId);
    }
}
