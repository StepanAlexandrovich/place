package com.market.place.controllers;

import com.market.place.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MenuController {
    @GetMapping("/user/menu")
    String menu(){
        return "user/menu";
    }
    @GetMapping("/admin/menu")
    String adminMenu(){
        return "admin/menu";
    }
    @GetMapping("/distributor/menu")
    String distributorMenu(){
        return "distributor/menu";
    }
}
