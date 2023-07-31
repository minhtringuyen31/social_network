package com.example.server.services;

import com.example.server.models.UserModel;
import com.example.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<UserModel> findAll(){
        return (List<UserModel>) repository.findAll();
    }

    public Optional<UserModel> findOne(int id){
        return repository.findById(id);
    }
}
