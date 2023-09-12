package com.example.mainapp.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDtoWithoutStory {
    private Long id;

    private String login;

    private String password;
}
