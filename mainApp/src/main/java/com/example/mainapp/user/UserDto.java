package com.example.mainapp.user;

import com.example.mainapp.story.StoryDtoWithoutOwner;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDto {
    private Long id;

    private String login;

    private String password;

    private List<StoryDtoWithoutOwner> stories;
}
