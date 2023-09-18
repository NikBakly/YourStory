package com.example.statisticapp.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class UserStatMapper {
    private UserStatMapper() {
    }

    public static UserStat toUserStat(UserStatDto userStatDto) {
        if (userStatDto == null) {
            return null;
        }
        UserStat resultUserStat = new UserStat();
        resultUserStat.setLogin(userStatDto.getLogin());
        resultUserStat.setOldUserId(userStatDto.getUserId());
        resultUserStat.setUserActionType(userStatDto.getUserActionType());
        resultUserStat.setActionTime(userStatDto.getActionTime());
        return resultUserStat;
    }

    public static UserStatDto toUserStatDto(UserStat userStat) {
        return Optional.ofNullable(userStat)
                .map(entity -> UserStatDto.builder()
                        .userId(entity.getOldUserId())
                        .login(entity.getLogin())
                        .actionTime(entity.getActionTime())
                        .userActionType(entity.getUserActionType())
                        .build())
                .orElse(null);
    }

    public static List<UserStatDto> toUsersStatDto(List<UserStat> userStats) {
        return Optional.ofNullable(userStats)
                .map(list -> list.stream()
                        .map(UserStatMapper::toUserStatDto)
                        .collect(Collectors.toList()))
                .orElse(null);
    }

}
