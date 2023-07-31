package com.example.server.controllers;

import com.example.server.models.FriendshipModel;
import com.example.server.models.FriendshipRequestModel;
import com.example.server.services.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/friendship")
public class FriendshipController {
    @Autowired
    private FriendshipService service;

    @PostMapping("/add")
    public FriendshipRequestModel requestAddFriendship(@RequestBody FriendshipRequestModel request) {
        FriendshipRequestModel res = service.requestAddFriend(request);
        return res;
    }

    @PostMapping("/{requestId}/accept")
    public FriendshipRequestModel requestAcceptFriendship(@PathVariable int requestId) {
        FriendshipRequestModel res = service.requestAcceptFriend(requestId);
        return res;
    }

    @PostMapping("/{requestId}/decline")
    public FriendshipRequestModel requestDeclineFriendship(@PathVariable int requestId) {
        FriendshipRequestModel res = service.requestDeclineFriend(requestId);
        return res;
    }

    @PostMapping("/unfriend")
    public void requestUnFriendship(@RequestBody FriendshipModel request){
        service.requestUnFriendship(request);
    }
}
