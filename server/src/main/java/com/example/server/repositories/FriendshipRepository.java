package com.example.server.repositories;
import com.example.server.models.FriendshipModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FriendshipRepository extends CrudRepository<FriendshipModel, Integer> {
    @Query("SELECT fs FROM FriendshipModel AS fs WHERE fs.userId = :userId AND fs.friendId = :friendId")
    FriendshipModel findFriendshipByUserIdAndFriendId(@Param("userId") int userId, @Param("friendId") int friendId);

}
