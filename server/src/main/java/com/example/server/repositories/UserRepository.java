package com.example.server.repositories;
import com.example.server.models.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
}
