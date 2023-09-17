package com.example.statisticapp.userstat;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStatRepository extends MongoRepository<UserStat, String> {

    List<UserStat> findAllByOldUserIdOrderByActionTimeDesc(Long oldUserId);

    List<UserStat> findAllByOrderByActionTimeDesc();
}
