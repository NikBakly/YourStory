package com.example.statisticapp.userstat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_stat")
public class UserStat {
    private String id;
    private Long oldUserId;
    private String login;
    private UserActionType userActionType;
    private Instant actionTime;
}
