package com.market.place.controllers;

import com.market.place.models.ProductCategory;
import com.market.place.services.impl.ProductCategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/product_category")
@RequiredArgsConstructor
public class ProductCategoryController {
    private final ProductCategoryServiceImpl productCategoryService;

    @GetMapping("/")
    public String getAllCategory(Model model, Principal principal){
        String role = ((UsernamePasswordAuthenticationToken) principal).getAuthorities().stream().toList().get(0).getAuthority();

        List<ProductCategory> productCategories = productCategoryService.getAll();
        model.addAttribute("productCategories",productCategories);
        model.addAttribute("userRole",role);
        return "products/productCategory";  // поменять камелкейс
    }

}
