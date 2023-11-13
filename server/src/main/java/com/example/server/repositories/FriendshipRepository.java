package com.example.server.repositories;
import com.example.server.models.FriendshipModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FriendshipRepository extends CrudRepository<FriendshipModel, Integer> {
    @Query("SELECT fs FROM FriendshipModel AS fs WHERE fs.firstUser = :firstUser AND fs.secondUser = :secondUser")
    FriendshipModel findFriendshipByUserIdAndFriendId(@Param("firstUser") int firstUser, @Param("secondUser") int secondUser);

}
