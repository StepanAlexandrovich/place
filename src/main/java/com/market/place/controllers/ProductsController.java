package com.market.place.controllers;

import com.market.place.models.ProductCategory;
import com.market.place.models.ProductSubCategory;
import com.market.place.services.impl.ProductServiceImpl;
import com.market.place.services.impl.ProductSubCategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductSubCategoryServiceImpl productSubCategoryService;
    private final ProductServiceImpl productService;

    @GetMapping(value = "/{productSubCategoryId}")
    public String getAllProducts(@PathVariable Long productSubCategoryId, Model model, Principal principal){  // изм назв
        String role = ((UsernamePasswordAuthenticationToken) principal).getAuthorities().stream().toList().get(0).getAuthority();
        ProductSubCategory productSubCategory = productSubCategoryService.getById(productSubCategoryId);

        model.addAttribute("products",productSubCategory.getProducts());
        model.addAttribute("productSubCategory",productSubCategory);
        model.addAttribute("userRole",role);

        return "products/products";
    }
}
