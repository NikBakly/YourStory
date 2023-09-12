package com.example.mainapp.user;

import com.example.mainapp.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserDto createUser(UserDtoWithoutStory newUser) {
        User user = userRepository.save(UserMapper.toUser(newUser));
        log.info("Пользователь с id={} успешно создан", user.getId());
        return UserMapper.toUserDto(user);
    }


    @Transactional(readOnly = true)
    public UserDto findUserById(Long userId) {
        UserDto foundUserDto = UserMapper
                .toUserDto(checkAndGetUserById(userId));
        log.info("Пользователь с id={} успешно найден", userId);
        return foundUserDto;
    }

    @Transactional(readOnly = true)
    public List<UserDto> findAllUsers() {
        List<UserDto> foundUsersDto = UserMapper.toUserDtoList(userRepository.findAll());
        log.info("Все пользователи успешно найдены");
        return foundUsersDto;
    }

    @Transactional
    public UserDto updateUser(UserDtoWithoutStory updatedUserDto) {
        User oldUser = checkAndGetUserById(updatedUserDto.getId());
        if (!oldUser.getLogin().equals(updatedUserDto.getLogin())) {
            oldUser.setLogin(updatedUserDto.getLogin());
        }
        if (!oldUser.getPassword().equals(updatedUserDto.getPassword())) {
            oldUser.setPassword(updatedUserDto.getPassword());
        }
        userRepository.save(oldUser);
        log.info("Пользователь с id={} успешно обновлен", oldUser.getId());
        return UserMapper.toUserDto(oldUser);
    }

    @Transactional
    public void deleteById(Long userId) {
        User foundUser = checkAndGetUserById(userId);
        userRepository.delete(foundUser);
        log.info("Пользователь с id={} успешно удален", userId);
    }

    private User checkAndGetUserById(Long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("Пользователь с id=%d не найден", userId)));
    }
}
