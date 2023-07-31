package com.example.server.services;

import com.example.server.constant.Status;
import com.example.server.models.FriendshipModel;
import com.example.server.models.FriendshipRequestModel;
import com.example.server.repositories.FriendshipRepository;
import com.example.server.repositories.FriendshipRequestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
public class FriendshipService {
    @Autowired
    private FriendshipRepository friendshipRepository;
    @Autowired
    private FriendshipRequestRepository friendshipRequestRepository;

    public FriendshipRequestModel requestAddFriend(FriendshipRequestModel request){
        return friendshipRequestRepository.save(request);
    }

    public FriendshipRequestModel requestAcceptFriend(int friendshipRequestId){
        FriendshipRequestModel request = friendshipRequestRepository.findById(friendshipRequestId)
                .orElseThrow(() -> new EntityNotFoundException("Friendship request not found."));
        request.setStatus(Status.ACCEPTED);

        FriendshipModel friendshipModel = new FriendshipModel();
        friendshipModel.setUserId(request.getSenderId());
        friendshipModel.setFriendId(request.getReceiverId());
        friendshipModel.setFriendshipDate(String.valueOf(LocalDateTime.now()));

        friendshipRepository.save(friendshipModel);
        return friendshipRequestRepository.save(request);
    }

    public FriendshipRequestModel requestDeclineFriend(int friendshipRequestId){
        FriendshipRequestModel request = friendshipRequestRepository.findById(friendshipRequestId)
                .orElseThrow(() -> new EntityNotFoundException("Friendship request not found."));
        request.setStatus(Status.DECLINED);
        return friendshipRequestRepository.save(request);
    }

    public void requestUnFriendship(FriendshipModel request){
        FriendshipModel friendship = friendshipRepository.findFriendshipByUserIdAndFriendId(request.getUserId(), request.getFriendId());
        friendshipRepository.delete(friendship);
    }
}
