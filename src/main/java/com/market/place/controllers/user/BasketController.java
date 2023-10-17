package com.market.place.controllers.user;

import com.market.place.models.Basket;
import com.market.place.models.User;
import com.market.place.services.impl.BasketServiceImpl;
import com.market.place.services.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("user/menu/baskets")
@RequiredArgsConstructor
@Slf4j
public class BasketController {
    private final BasketServiceImpl basketService;
    private final ProductServiceImpl productService;

    //// baskets -----------------------------
    @GetMapping("")
    String baskets(Model model, Principal principal){
        User user = ((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());

        List<Basket> baskets = basketService.getAllByUserId(user.getId());
        model.addAttribute("baskets",baskets);
        return "user/baskets_folder/baskets";
    }
    @GetMapping("/basket/{basketId}")
    String basket(@PathVariable Long basketId,Model model){
        Basket basket = basketService.getById(basketId);
        model.addAttribute("basket",basket);
        return "user/baskets_folder/basket";
    }
    @PostMapping("/add_basket")
    public String addBasket(String basketName,Model model,Principal principal){
        User user = ((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        basketService.createBasket(basketName,user);
        return baskets(model,principal);
    }

    //// add product in basket --------------------------------------
    // step 1 -> select product
    @GetMapping(value = "/add_product_in_basket/select_product/{productId}")
    String addProductInBasket(@PathVariable Long productId, Model model,Principal principal){
        User user = ((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());

        model.addAttribute("baskets",basketService.getAllByUserId(user.getId()));
        model.addAttribute("product",productService.getById(productId));
        return "user/baskets_folder/select_basket_add_product";
    }
    // step 1 -> select basket
    @GetMapping("/add_product_in_basket/select_basket/{productId}/{basketId}")
    String addProductInBasket(@PathVariable Long productId,@PathVariable Long basketId,Model model){
        basketService.addProduct(productId,basketId);
        return basket(basketId,model);
    }

}
