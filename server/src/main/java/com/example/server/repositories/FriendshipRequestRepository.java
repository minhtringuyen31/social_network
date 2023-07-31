package com.example.server.repositories;

import com.example.server.models.FriendshipRequestModel;
import org.springframework.data.repository.CrudRepository;

public interface FriendshipRequestRepository extends CrudRepository<FriendshipRequestModel, Integer> {
}
