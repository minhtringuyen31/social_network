package com.example.server.models;

import com.example.server.constant.Role;
import com.example.server.security.token.TokenModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class UserModel implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(nullable = false, length = 45)
    @JoinColumn(name = "first_name")
    private String firstName;
    @Column(nullable = true, length = 45)
    @JoinColumn(name = "last_name")
    private String lastName;
    @Column(nullable = true, unique = true, length = 45)
    private String email;
    @Column(nullable = false, unique = true, length = 45)
    private String phoneNumber;
    @Column(nullable = false, length = 15)
    private String password;
    @Column(nullable = true)
    private String profilePicture;
    @Column(nullable = true)
    private String dateOfBirth;
    @Column(nullable = true)
    private String registrationDate;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<TokenModel> tokens;

    public Integer getId() {
        return userId;
    }

    public void setId(Integer id) {
        this.userId = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    @Override
    public String getPassword(){
        return password;
    }
    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @PrePersist
    public void setRegistrationDate() {
        if (registrationDate == null) {
            registrationDate = String.valueOf(LocalDateTime.now());
        }
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", role=" + role +
                ", tokens=" + tokens +
                '}';
    }
}


