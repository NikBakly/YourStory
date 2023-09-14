package com.example.statisticapp.userStat;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/stat/users")
@AllArgsConstructor
public class UserStatController {
    private final UserStatService userStatService;

    @PostMapping
    public void createUserStat(@RequestBody UserStatDto userStatDto) {
        userStatService.createUserStat(userStatDto);
    }

    @GetMapping("/{userLogin}")
    public List<UserStatDto> findUsersStatByLogin(@PathVariable String userLogin) {
        return userStatService.findUsersStatByLogin(userLogin);
    }

    @GetMapping
    public List<UserStatDto> findAllUsersStat() {
        return userStatService.findAllUsersStat();
    }

}
