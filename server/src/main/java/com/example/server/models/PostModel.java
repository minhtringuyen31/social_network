package com.example.server.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(nullable = false)
    @JoinColumn(name = "user_id")
    private Integer userId;
    @Column(nullable = true, unique = true, length = 100)
    private String content;
    @Column(nullable = true, unique = true, length = 100)
    private String media;
    @Column(nullable = false, unique = true, length = 45)
    private String createDate;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getCreateDate() {
        return createDate;
    }

    @PrePersist
    public void setCreateDate() {
        if (createDate == null) {
            createDate = String.valueOf(LocalDateTime.now());
        }
    }
}
