package com.example.server.repositories;
import com.example.server.models.FriendshipModel;
import org.springframework.data.repository.CrudRepository;

public interface FriendshipRepository extends CrudRepository<FriendshipModel, Integer> {
}
