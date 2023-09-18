package com.example.statisticapp.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stat/users")
@AllArgsConstructor
public class UserStatController {
    private final UserStatService userStatService;

    @GetMapping("/{oldUserId}")
    public List<UserStatDto> findUsersStatByLogin(@PathVariable Long oldUserId) {
        return userStatService.findUsersStatByLogin(oldUserId);
    }

    @GetMapping
    public List<UserStatDto> findAllUsersStat() {
        return userStatService.findAllUsersStat();
    }

}
