package com.example.server.repositories;
import com.example.server.models.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
    Optional<UserModel> findByEmail(String email);
}
