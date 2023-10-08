package com.market.place.controllers;

import com.market.place.models.Basket;
import com.market.place.models.Distributor;
import com.market.place.models.Product;
import com.market.place.models.User;
import com.market.place.services.impl.BasketServiceImpl;
import com.market.place.services.impl.DistributorServiceImpl;
import com.market.place.services.impl.ProductServiceImpl;
import com.market.place.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class StartController {
    private final JdbcTemplate jdbcTemplate;
    private final DistributorServiceImpl distributorService;
    private final UserServiceImpl userService;

    private final ProductServiceImpl productService;
    private final BasketServiceImpl basketService;
    @GetMapping("/start")
    String start(Principal principal){
        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();

        test2();

        return "start";
    }

    private void test2(){
        //basketService.createBasket("Basket2");

//        basketService.addProduct(7L,1L);
//        basketService.addProduct(9L,1L);
//        basketService.addProduct(7L,2L);
//        basketService.addProduct(9L,2L);
//        basketService.addProduct(10L,2L);


        List<Product> allByBasketId = productService.getAllByBasketId(1L);
        for (Product product : allByBasketId) {
            System.out.println(product.getName());
        }
        System.out.println("----------------");
        List<Product> allByBasketId1 = productService.getAllByBasketId(2L);
        for (Product product : allByBasketId1) {
            System.out.println(product.getName());
        }
        System.out.println("----------------");
    }

    private void test(){
        System.out.println("-------------");
        for (Distributor distributor : distributorService.getAll()) {
            System.out.println(distributor.getName());
        }
        System.out.println("---------------------");
        for (User user1 : userService.getAll()) {
            System.out.println(user1.getLogin());
        }
    }

    public List<User> list(){
        return jdbcTemplate.query("SELECT* FROM public.users;",new BeanPropertyRowMapper<>(User.class));
    }

}
