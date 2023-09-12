package com.example.mainapp.story;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoryDtoWithoutOwner {
    private Long id;

    private String description;

    private String text;

}
