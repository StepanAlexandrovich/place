package com.market.place.controllers;

import com.market.place.models.ProductCategory;
import com.market.place.models.ProductSubCategory;
import com.market.place.services.impl.ProductSubCategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product_subcategory")
@RequiredArgsConstructor
public class ProductSubCategoryController {
    private final ProductSubCategoryServiceImpl productSubCategoryService;

    @GetMapping("/")
    public String getAllSubCategory(Model model, Principal principal){
        String role = ((UsernamePasswordAuthenticationToken) principal).getAuthorities().stream().toList().get(0).getAuthority();
        List<ProductSubCategory> productSubCategories = productSubCategoryService.getAll();

        for (ProductSubCategory productSubCategory : productSubCategories) {
            System.out.println(productSubCategory.getName());
        }

        model.addAttribute("productSubCategories",productSubCategories);
        model.addAttribute("userRole",role);
        return "products/productSubCategory";
    }

    @GetMapping(value = "/{productSubCategoryId}")
    public String getAllSubCategories(@PathVariable String productSubCategoryId,Model model, Principal principal){
        String role = ((UsernamePasswordAuthenticationToken) principal).getAuthorities().stream().toList().get(0).getAuthority();

        List<ProductSubCategory> productSubCategories = productSubCategoryService.getAllByProductCategoryId(Long.parseLong(productSubCategoryId));
        model.addAttribute("productSubCategories",productSubCategories);
        model.addAttribute("userRole",role);
        return "products/productSubCategory";
    }

}
