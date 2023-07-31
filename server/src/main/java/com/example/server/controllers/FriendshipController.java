package com.example.server.controllers;

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
    public FriendshipRequestModel requestAddFriendship(@RequestBody FriendshipRequestModel request){
        FriendshipRequestModel res = service.requestAddFriend(request);
        return res;
    }

    @PostMapping("/accept")
    public FriendshipRequestModel requestAcceptFriendship(@RequestBody FriendshipRequestModel request) {
        FriendshipRequestModel res = service.requestAddFriend(request);
        return res;
    }
}
