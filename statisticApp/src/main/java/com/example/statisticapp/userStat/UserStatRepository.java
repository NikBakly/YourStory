package com.example.statisticapp.userStat;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStatRepository extends MongoRepository<UserStat, String> {

    List<UserStat> findAllByLoginOrderByActionTimeDesc(String login);

    List<UserStat> findAllByOrderByActionTimeDesc();
}
