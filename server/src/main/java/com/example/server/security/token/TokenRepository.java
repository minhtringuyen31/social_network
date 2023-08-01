package com.example.server.security.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<TokenModel, Integer> {
    @Query("SELECT t FROM TokenModel AS t INNER JOIN UserModel u ON t.user.userId = u.userId WHERE u.userId = :userId AND (t.expired = false or t.revoked = false)")
    List<TokenModel> findAllValidTokenByUser(Integer userId);
//    @Query(value = """
//      select t from TokenModel t inner join UserModel u\s
//      on t.user.userId = u.userId\s
//      where u.userId = :id and (t.expired = false or t.revoked = false)\s
//      """)
//    List<TokenModel> findAllValidTokenByUser(Integer userId);
//
    Optional<TokenModel> findByToken(String token);
}
