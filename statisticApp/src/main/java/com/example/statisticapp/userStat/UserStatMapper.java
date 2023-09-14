package com.example.statisticapp.userStat;

import java.util.ArrayList;
import java.util.List;

public final class UserStatMapper {
    private UserStatMapper() {
    }

    public static UserStat toUserStat(UserStatDto userStatDto) {
        if (userStatDto == null) {
            return null;
        }
        UserStat resultUserStat = new UserStat();
        resultUserStat.setLogin(userStatDto.getLogin());
        resultUserStat.setActionType(userStatDto.getActionType());
        resultUserStat.setActionTime(userStatDto.getActionTime());
        return resultUserStat;
    }

    public static UserStatDto toUserStatDto(UserStat userStat) {
        if (userStat == null) {
            return null;
        }
        return new UserStatDto(userStat.getLogin(),
                userStat.getActionType(),
                userStat.getActionTime());
    }

    public static List<UserStatDto> toUsersStatDto(List<UserStat> userStats) {
        if (userStats == null) {
            return null;
        }
        List<UserStatDto> result = new ArrayList<>();
        userStats.forEach(userStat -> result.add(toUserStatDto(userStat)));
        return result;
    }

}
