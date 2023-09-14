package com.example.statisticapp.userStat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Slf4j
@Validated
@AllArgsConstructor
public class UserStatService {
    private final UserStatRepository userStatRepository;

    public void createUserStat(@Valid UserStatDto userStatDto) {
        UserStat userStat = UserStatMapper.toUserStat(userStatDto);
        userStatRepository.save(userStat);
        log.info("Статистика пользователя с id={} успешно добавлена", userStat.getId());
    }

    public List<UserStatDto> findUsersStatByLogin(@NotBlank(message = "Поле login не должно быть пустым")
                                                  String login) {
        List<UserStat> foundUserStat = userStatRepository
                .findAllByLoginOrderByActionTimeDesc(login);
        List<UserStatDto> foundUsersStatDto = UserStatMapper.toUsersStatDto(foundUserStat);
        log.info("Статистика пользователя с login={} успешно найдена", login);
        return foundUsersStatDto;
    }

    public List<UserStatDto> findAllUsersStat() {
        List<UserStatDto> foundUsersStatDto = UserStatMapper
                .toUsersStatDto(userStatRepository.findAllByOrderByActionTimeDesc());
        log.info("Вся статистика пользователей найдена");
        return foundUsersStatDto;
    }
}
