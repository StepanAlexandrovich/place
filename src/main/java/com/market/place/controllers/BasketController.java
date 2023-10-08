package com.market.place.controllers;

import com.market.place.models.Basket;
import com.market.place.models.User;
import com.market.place.services.impl.BasketServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/baskets")
@RequiredArgsConstructor
public class BasketController {
    private final BasketServiceImpl basketService;


    @GetMapping("/baskets")
    String baskets(Model model, Principal principal){
        User user = ((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());

        List<Basket> baskets = basketService.getAllByUserId(user.getId());
        model.addAttribute("baskets",baskets);
        return "baskets/baskets";
    }

    @GetMapping("/basket/{basketId}")
    String basket(@PathVariable Long basketId,Model model){
        Basket basket = basketService.getById(basketId);
        model.addAttribute("products",basket.getProducts());
        model.addAttribute("basket",basket);
        return "baskets/basket";
    }

    @PostMapping("/add_product_in_basket")
    String addProductInBasket(Long productId,Long basketId){
        basketService.addProduct(productId,basketId);
        return "redirect:/baskets/basket/" + basketId;
    }

    @PostMapping("/add_basket")
    public String addBasket(String basketName,Principal principal){
        User user = ((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        basketService.createBasket(basketName,user);
        //log.info("Создана корзина: " + name);
        return "redirect:/baskets/baskets";
    }
}
