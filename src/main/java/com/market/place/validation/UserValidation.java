package com.market.place.validation;

import com.market.place.dto.UserCreateDto;
import com.market.place.models.User;
import com.market.place.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UserValidation implements Validator {
    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserCreateDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateDto userCreateDto = (UserCreateDto) target;
        User byLogin = userRepository.findByLogin(userCreateDto.getLogin());
        if(byLogin!=null){
            errors.rejectValue("login","EXIST","Login exist");
        }
    }
}
