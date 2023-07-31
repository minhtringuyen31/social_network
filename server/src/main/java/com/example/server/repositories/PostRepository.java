package com.example.server.repositories;

import com.example.server.models.PostModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends CrudRepository<PostModel, Integer> {
    @Query("SELECT p FROM PostModel p WHERE p.userId = :userId")
    public List<PostModel> getAllByUserId(@Param("userId") int userI);
}
