package com.market.place.controllers;

import com.market.place.models.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping
public class StartController {

    @GetMapping("/start")
    String start(Principal principal){
        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();

        return "start";
    }
}
