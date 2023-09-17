package com.example.mainapp.user;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class UserMapper {
    private UserMapper() {
    }

    public static UserDto toUserDto(User user) {
        return Optional.ofNullable(user)
                .map(entity -> UserDto.builder()
                        .id(entity.getId())
                        .login(entity.getLogin())
                        .password(entity.getPassword())
                        .build())
                .orElse(null);

    }

    public static User toUser(UserDto userDto) {
        return Optional.ofNullable(userDto)
                .map(dto -> new User(
                        dto.getId(),
                        dto.getLogin(),
                        dto.getPassword()))
                .orElse(null);

    }

    public static List<UserDto> toUserDtoList(List<User> users) {
        return Optional.ofNullable(users)
                .map(list -> list.stream()
                        .map(UserMapper::toUserDto)
                        .collect(Collectors.toList()))
                .orElse(null);
    }

    public static UserStatDto toUserStatDto(User user, UserActionType userActionType) {
        return Optional.ofNullable(user)
                .map(dtoStat -> UserStatDto.builder()
                        .userId(user.getId())
                        .login(user.getLogin())
                        .actionTime(Instant.now())
                        .userActionType(userActionType)
                        .build())
                .orElse(null);
    }
}
