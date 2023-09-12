package com.example.mainapp.story;

import com.example.mainapp.user.UserMapper;

import java.util.ArrayList;
import java.util.List;

public final class StoryMapper {

    private StoryMapper() {
    }

    public static StoryDto toStoryDto(Story story) {
        return StoryDto.builder()
                .id(story.getId())
                .description(story.getDescription())
                .text(story.getText())
                .owner(UserMapper.toUserDtoWithoutStory(story.getOwner()))
                .build();
    }

    public static StoryDtoWithoutOwner toStoryDtoWithoutOwner(Story story) {
        return StoryDtoWithoutOwner.builder()
                .id(story.getId())
                .description(story.getDescription())
                .text(story.getText())
                .build();
    }

    public static Story toStory(StoryDto storyDto) {
        return new Story(storyDto.getId(),
                storyDto.getDescription(),
                storyDto.getText(),
                UserMapper.toUser(storyDto.getOwner()));
    }

    public static Story toStory(StoryDtoWithoutOwner storyDtoWithoutOwner) {
        return new Story(storyDtoWithoutOwner.getId(),
                storyDtoWithoutOwner.getDescription(),
                storyDtoWithoutOwner.getText(),
                null);
    }

    public static List<StoryDto> toStoriesDto(Iterable<Story> stories) {
        List<StoryDto> result = new ArrayList<>();
        if (stories != null) {
            stories.forEach(story -> result.add(toStoryDto(story)));
        }
        return result;
    }

    public static List<StoryDtoWithoutOwner> toStoriesDtoWithoutOwner(Iterable<Story> stories) {
        List<StoryDtoWithoutOwner> result = new ArrayList<>();
        if (stories != null) {
            stories.forEach(story -> result.add(toStoryDtoWithoutOwner(story)));
        }
        return result;
    }

    public static List<Story> toStoriesFromDto(List<StoryDto> storiesDto) {
        List<Story> result = new ArrayList<>();
        if (storiesDto != null) {
            storiesDto.forEach(storyDto -> result.add(toStory(storyDto)));
        }
        return result;
    }

    public static List<Story> toStoriesFromDtoWithoutOwner(List<StoryDtoWithoutOwner> storiesDtoWithoutOwner) {
        List<Story> result = new ArrayList<>();
        if (storiesDtoWithoutOwner != null) {
            storiesDtoWithoutOwner.forEach(storyDto -> result.add(toStory(storyDto)));
        }
        return result;
    }


}

