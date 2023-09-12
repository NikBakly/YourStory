package com.example.mainapp.story;

import com.example.mainapp.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoryService {
    private final StoryRepository storyRepository;

    @Transactional
    public StoryDto createStory(StoryDto storyDto) {
        Story newStory = storyRepository.save(StoryMapper.toStory(storyDto));
        log.info("История с id={} успешно создана", newStory.getId());
        return StoryMapper.toStoryDto(newStory);
    }

    @Transactional(readOnly = true)
    public StoryDto findStoryById(Long storyId) {
        StoryDto foundStoryDto = StoryMapper.toStoryDto(checkAndGetStoryById(storyId));
        log.info("История с id={} успешно найдена", storyId);
        return foundStoryDto;

    }

    @Transactional(readOnly = true)
    public List<StoryDto> findAllStories() {
        List<StoryDto> foundStoriesDto = StoryMapper.toStoriesDto(storyRepository.findAll());
        log.info("Все истории успешно найдены");
        return foundStoriesDto;
    }

    @Transactional
    public StoryDto updateStory(StoryDtoWithoutOwner updatedStoryDtoWithoutOwner) {
        Story oldStory = checkAndGetStoryById(updatedStoryDtoWithoutOwner.getId());
        if (!oldStory.getDescription().equals(updatedStoryDtoWithoutOwner.getDescription())) {
            oldStory.setDescription(updatedStoryDtoWithoutOwner.getDescription());
        }
        if (!oldStory.getText().equals(updatedStoryDtoWithoutOwner.getText())) {
            oldStory.setText(updatedStoryDtoWithoutOwner.getText());
        }
        storyRepository.save(oldStory);
        log.info("История с id={} успешно обновлена", oldStory.getId());
        return StoryMapper.toStoryDto(oldStory);
    }

    @Transactional
    public void deleteStoryById(Long storyId) {
        Story foundStory = checkAndGetStoryById(storyId);
        storyRepository.delete(foundStory);
        log.info("История с id={} успешно удалена", storyId);
    }

    private Story checkAndGetStoryById(Long storyId) {
        return storyRepository.findById(storyId)
                .orElseThrow(() -> new NotFoundException(String.format("История с id=%d не найдена", storyId)));
    }

}
