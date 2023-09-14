package com.example.statisticapp.userStat;

import com.example.statisticapp.ActionType;
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
    private String login;
    private ActionType actionType;
    private Instant actionTime;
}
