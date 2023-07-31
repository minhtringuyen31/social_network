package com.example.server.models;

import jakarta.persistence.*;

@Entity
@Table(name = "friendships")
public class FriendshipModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer friendshipId;

    @Column(nullable = false)
    @JoinColumn(name = "user_id")
    private Integer userId;

    @Column(nullable = false)
    @JoinColumn(name = "user_id")
    private Integer friendId;

    @Column(nullable = true)
    private String friendshipDate;

    public Integer getFriendShipId() {
        return friendshipId;
    }

    public void setFriendshipId(Integer friendshipId) {
        this.friendshipId = friendshipId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getFriendshipDate() {
        return friendshipDate;
    }

    public void setFriendshipDate(String friendshipDate) {
        this.friendshipDate = friendshipDate;
    }

    @Override
    public String toString() {
        return "FriendshipModel{" +
                "friendshipId=" + friendshipId +
                ", userId=" + userId +
                ", friendId=" + friendId +
                ", friendshipDate='" + friendshipDate + '\'' +
                '}';
    }
}
