package com.example.statisticapp.userStat;

import com.example.statisticapp.ActionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStatDto {

    @NotBlank(message = "Поле login не должно быть пустым")
    private String login;

    @NotNull(message = "Поле actionType не должно быть null ")
    private ActionType actionType;

    @NotNull(message = "Поле actionTime не должно быть null")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Europe/Moscow")
    private Instant actionTime;
}
