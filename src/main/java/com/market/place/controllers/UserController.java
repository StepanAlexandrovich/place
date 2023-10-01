package com.market.place.controllers;

import com.market.place.dto.DistributorCreateDto;
import com.market.place.dto.UserCreateDto;
import com.market.place.services.impl.DistributorServiceImpl;
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
    private final DistributorServiceImpl distributorService;
    private final UserValidation userValidation;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/registration_client")
    public String registrationClient(Model model){
        model.addAttribute("userCreateDto",new UserCreateDto());
        return "registration_client";
    }
    @PostMapping("/registration_client")
    public String registrationClient(@Valid UserCreateDto userCreateDto, BindingResult bindingResult, Model model){
        userValidation.validate(userCreateDto,bindingResult);
        if(!bindingResult.hasErrors()){
            model.addAttribute("noErrors",true);
            userService.createUser(userCreateDto);
            return "login";
        }
        model.addAttribute("userCreateDto",userCreateDto);
        return "registration_client";
    }
    @GetMapping("/registration_distributor")
    public String registrationDistributor(Model model){
        model.addAttribute("distributorCreateDto",new DistributorCreateDto());
        return "registration_distributor";
    }
    @PostMapping("/registration_distributor")
    public String registrationDistributor(@Valid DistributorCreateDto distributorCreateDto, BindingResult bindingResult,Model model){
        userValidation.validate(distributorCreateDto,bindingResult);
        if(!bindingResult.hasErrors()){
            model.addAttribute("noErrors",true);
            distributorService.createDistributor(distributorCreateDto);
            return "login";
        }
        model.addAttribute("distributorCreateDto",distributorCreateDto);
        return "registration_distributor";
    }

}
