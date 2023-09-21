package com.market.place.controllers;

import com.market.place.dto.UserCreateDto;
import com.market.place.services.impl.UserServiceImpl;
import com.market.place.validation.UserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    private final UserValidation userValidation;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userDto",new UserCreateDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationUser(@Valid UserCreateDto userCreateDto, BindingResult bindingResult,Model model){
        userValidation.validate(userCreateDto,bindingResult);

//        if(bindingResult.hasErrors()){
//
//            return "registration";
//        }else
        if(!bindingResult.hasErrors()){
            model.addAttribute("noErrors",true);
            userService.createUser(userCreateDto);
            return "login";
        }
        model.addAttribute("userDto",userCreateDto);
        return "registration";
    }
}
