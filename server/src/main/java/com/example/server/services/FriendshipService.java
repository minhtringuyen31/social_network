package com.example.server.services;

import com.example.server.models.FriendshipRequestModel;
import com.example.server.repositories.FriendshipRepository;
import com.example.server.repositories.FriendshipRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendshipService {
    @Autowired
    private FriendshipRepository fsRepo;
    @Autowired
    private FriendshipRequestRepository fsrRepo;

    public FriendshipRequestModel requestAddFriend(FriendshipRequestModel request){
        return fsrRepo.save(request);
    }
}
