package com.market.place.controllers;

import com.market.place.models.ProductCategory;
import com.market.place.models.ProductSubCategory;
import com.market.place.services.impl.ProductCategoryServiceImpl;
import com.market.place.services.impl.ProductSubCategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("menu/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductCategoryServiceImpl productCategoryService;
    private final ProductSubCategoryServiceImpl productSubCategoryService;
    @GetMapping("/product_category")
    public String getAllCategory(Model model, Principal principal){
        String role = ((UsernamePasswordAuthenticationToken) principal).getAuthorities().stream().toList().get(0).getAuthority();

        List<ProductCategory> productCategories = productCategoryService.getAll();
        model.addAttribute("productCategories",productCategories);
        model.addAttribute("userRole",role);
        return "products/product_category";
    }
    @GetMapping(value = "/product_category/product_subcategory/{productCategoryId}")
    public String getAllSubCategories(@PathVariable Long productCategoryId,Model model, Principal principal){
        String role = ((UsernamePasswordAuthenticationToken) principal).getAuthorities().stream().toList().get(0).getAuthority();
        ProductCategory productCategory = productCategoryService.getById(productCategoryId);

        model.addAttribute("productSubCategories",productCategory.getProductSubCategories());
        model.addAttribute("productCategory",productCategory);
        model.addAttribute("userRole",role);

        return "products/productSubCategory";
    }
    @GetMapping(value = "/product_category/product_subcategory/products/{productSubCategoryId}")
    public String getAllProducts(@PathVariable Long productSubCategoryId, Model model, Principal principal){  // изм назв
        String role = ((UsernamePasswordAuthenticationToken) principal).getAuthorities().stream().toList().get(0).getAuthority();
        ProductSubCategory productSubCategory = productSubCategoryService.getById(productSubCategoryId);

        model.addAttribute("products",productSubCategory.getProducts());
        model.addAttribute("productSubCategory",productSubCategory);
        model.addAttribute("userRole",role);

        return "products/products";
    }


}
