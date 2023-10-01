package com.market.place.controllers;

import com.market.place.dto.UserCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class DistributorController {
//    @GetMapping("/registration")
//    public String registration(Model model){
//        model.addAttribute("userCreateDto",new UserCreateDto());
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String registrationUser(@Valid UserCreateDto userCreateDto, BindingResult bindingResult, Model model){
//        userValidation.validate(userCreateDto,bindingResult);
//        if(!bindingResult.hasErrors()){
//            model.addAttribute("noErrors",true);
//            userService.createUser(userCreateDto);
//            return "login";
//        }
//        model.addAttribute("userCreateDto",userCreateDto);
//        return "registration";
//    }
}
