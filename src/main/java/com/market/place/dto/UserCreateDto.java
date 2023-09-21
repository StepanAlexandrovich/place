package com.market.place.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserCreateDto {
    @Pattern(regexp = "[A-Z][a-z]*",message = "Текст должен быть на английском,должно начинаться с большой буквы")
    @Size(min = 8,max = 20,message = "Field must be не попадает в пределы 8 - 20 знаков")
    @NotEmpty(message = "Field login must not be empty")
    private String login;
    @Size(min = 5,max = 20,message = "Field must be не попадает в пределы 5 - 20 знаков")

    // TODO: 21.09.2023  написать регулярные выражения пароль должен содержать одну цифру один символ в нижнем регистре. в верхнем регистре один специальный символ длина от пяти до 20
    private String password;

}
