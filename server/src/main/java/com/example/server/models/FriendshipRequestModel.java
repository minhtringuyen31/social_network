package com.example.server.models;

import com.example.server.constant.Status;
import com.example.server.repositories.FriendshipRequestRepository;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "friendshiprequests")
@NoArgsConstructor
public class FriendshipRequestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer friendshipRequestId;

    @Column(nullable = false)
    private Integer senderId;

    @Column(nullable = false)
    private Integer receiverId;

    @Column(nullable = true)
    private String requestDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @PrePersist
    private void setDefaultValues() {
        if (status == null) {
            status =  Status.PENDING;
        }

        if (requestDate == null) {
            requestDate = String.valueOf(LocalDateTime.now());
        }
    }
}

