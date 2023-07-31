package com.example.server.models;

import com.example.server.repositories.FriendshipRequestRepository;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "friendshiprequest")
@NoArgsConstructor
public class FriendshipRequestModel {
    public enum Status {
        PENDING,
        ACCEPTED,
        DECLINED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer friendshipRequestId;

    @Column(nullable = false)
    private Integer senderId;

    @Column(nullable = false)
    private Integer receiverId;

    @Column(nullable = true)
    private String requestDate;

    @Column(nullable = false)
    private String status;

    public FriendshipRequestModel(int senderId, int receiverId){
        String requestDate = String.valueOf(LocalDateTime.now());
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.requestDate = requestDate;
        this.status = "pending";
    }

    public Integer getFriendshipRequestId() {
        return friendshipRequestId;
    }

    public void setFriendshipRequestId(Integer friendshipRequestId) {
        this.friendshipRequestId = friendshipRequestId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @PrePersist
    private void setDefaultValues() {
        if (status == null) {
            status = String.valueOf(Status.PENDING);
        }

        if (requestDate == null) {
            requestDate = String.valueOf(LocalDateTime.now());
        }
    }
}

