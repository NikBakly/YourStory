package com.example.mainapp.story;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stories")
public class StoryController {
    private final StoryService storyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StoryDto createStory(@RequestBody StoryDto storyDto) {
        return storyService.createStory(storyDto);
    }

    @GetMapping("/{storyId}")
    public StoryDto findStoryById(@PathVariable Long storyId) {
        return storyService.findStoryById(storyId);
    }

    @GetMapping
    public List<StoryDto> findAllStories() {
        return storyService.findAllStories();
    }

    @PatchMapping
    public StoryDto updateStory(@RequestBody StoryDtoWithoutOwner updatesStoryDtoWithoutOwner) {
        return storyService.updateStory(updatesStoryDtoWithoutOwner);
    }

    @DeleteMapping("/{storyId}")
    public void deleteStoryById(@PathVariable Long storyId) {
        storyService.deleteStoryById(storyId);
    }
}
