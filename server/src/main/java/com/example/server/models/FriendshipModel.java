package com.example.server.models;

import jakarta.persistence.*;

@Entity
@Table(name = "friendships")
public class FriendshipModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer friendshipId;

    @Column(nullable = false)
    private Integer user_id;

    @Column(nullable = false)
    private Integer friend_id;

    @Column(nullable = true)
    private String friendshipDate;

    public Integer getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(Integer friendshipId) {
        this.friendshipId = friendshipId;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(Integer friend_id) {
        this.friend_id = friend_id;
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
                ", user_id=" + user_id +
                ", friend_id=" + friend_id +
                ", friendshipDate='" + friendshipDate + '\'' +
                '}';
    }

}
