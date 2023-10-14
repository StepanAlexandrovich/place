package com.market.place.controllers;

import com.market.place.models.*;
import com.market.place.repositories.BasketProductRepository;
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

    private final BasketProductRepository basketProductRepository;
    @GetMapping("/start")
    String start(Principal principal){
        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();

        //test();
//        BasketProduct basketProduct = new BasketProduct();
//        basketProduct.setId(new BasketProductKey(1L,7L));
//        basketProduct.setBasket(basketService.getById(1L));
//        basketProduct.setProduct(productService.getById(7L));
//        basketProduct.setProductsCount(1L);
//        basketProductRepository.save(basketProduct);


          //System.out.println(basketProductRepository.getReferenceById(new BasketProductKey(2L, 7L)) );

        //BasketProduct referenceById = basketProductRepository.getReferenceById());



        BasketProduct referenceById = basketProductRepository.findById(new BasketProductKey(1L,7L)).orElse(null);



        System.out.println(basketProductRepository.getReferenceById(new BasketProductKey(1L,7L)).getProduct().getName());
        System.out.println(basketProductRepository.getReferenceById(new BasketProductKey(1L,7L)).getBasket().getName());

        return "start";
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
