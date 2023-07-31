package com.example.server.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @Column(nullable = false, length = 45)
    private String username;
    @Column(nullable = true, unique = true, length = 45)
    private String email;
    @Column(nullable = false, unique = true, length = 45)
    private String phoneNumber;
    @Column(nullable = false, length = 15)
    private String password;
    @Column(nullable = true)
    private String profile_picture;
    @Column(nullable = true)
    private String registrationDate;
    @Column(nullable = true)
    private String dateOfBirth;

    public Integer getId() {
        return user_id;
    }

    public void setId(Integer id) {
        this.user_id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", profile_picture='" + profile_picture + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}


