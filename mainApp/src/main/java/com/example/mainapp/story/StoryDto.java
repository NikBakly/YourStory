package com.example.mainapp.story;

import com.example.mainapp.user.UserDtoWithoutStory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoryDto {

    private Long id;

    private String description;

    private String text;

    private UserDtoWithoutStory owner;
}
