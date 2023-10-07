package com.market.place.controllers;

import com.market.place.models.ProductCategory;
import com.market.place.services.impl.ProductCategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/product_subcategory")
@RequiredArgsConstructor
public class ProductSubCategoryController {
    private final ProductCategoryServiceImpl productCategoryService;

    @GetMapping(value = "/{productCategoryId}")
    public String getAllSubCategories(@PathVariable Long productCategoryId,Model model, Principal principal){
        String role = ((UsernamePasswordAuthenticationToken) principal).getAuthorities().stream().toList().get(0).getAuthority();
        ProductCategory productCategory = productCategoryService.getById(productCategoryId);

        model.addAttribute("productSubCategories",productCategory.getProductSubCategories());
        model.addAttribute("productCategory",productCategory);
        model.addAttribute("userRole",role);

        return "products/productSubCategory";
    }

}
