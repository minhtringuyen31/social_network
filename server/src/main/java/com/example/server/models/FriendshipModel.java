package com.example.server.models;

import jakarta.persistence.*;

@Entity
@Table(name = "friendships")
public class FriendshipModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer friendshipId;

    @Column(nullable = false)
    @JoinColumn(name = "fisrt_user")
    private Integer firstUser;

    @Column(nullable = false)
    @JoinColumn(name = "second_user")
    private Integer secondUser;

    @Column(nullable = true)
    private String friendshipDate;

    public Integer getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(Integer friendshipId) {
        this.friendshipId = friendshipId;
    }

    public Integer getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(Integer firstUser) {
        this.firstUser = firstUser;
    }

    public Integer getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(Integer secondUser) {
        this.secondUser = secondUser;
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
                ", firstUser=" + firstUser +
                ", secondUser=" + secondUser +
                ", friendshipDate='" + friendshipDate + '\'' +
                '}';
    }
}
