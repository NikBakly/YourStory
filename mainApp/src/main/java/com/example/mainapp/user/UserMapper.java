package com.example.mainapp.user;

import com.example.mainapp.story.StoryMapper;

import java.util.ArrayList;
import java.util.List;

public final class UserMapper {
    private UserMapper() {
    }

    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .stories(StoryMapper.toStoriesDtoWithoutOwner(user.getStories()))
                .build();
    }

    public static UserDtoWithoutStory toUserDtoWithoutStory(User user) {
        return UserDtoWithoutStory.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }


    public static User toUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getLogin(),
                userDto.getPassword(),
                StoryMapper.toStoriesFromDtoWithoutOwner(userDto.getStories())
        );
    }

    public static User toUser(UserDtoWithoutStory userDtoWithoutStory) {
        return new User(
                userDtoWithoutStory.getId(),
                userDtoWithoutStory.getLogin(),
                userDtoWithoutStory.getPassword(),
                null
        );
    }

    public static List<UserDto> toUserDtoList(Iterable<User> users) {
        List<UserDto> result = new ArrayList<>();
        users.forEach(user -> result.add(toUserDto(user)));
        return result;
    }
}
