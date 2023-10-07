package com.market.place.controllers;

import com.market.place.services.impl.ProductCategoryServiceImpl;
import com.market.place.services.impl.ProductServiceImpl;
import com.market.place.services.impl.ProductSubCategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminController {
    private final ProductCategoryServiceImpl productCategoryService;
    private final ProductSubCategoryServiceImpl productSubCategoryService;
    private final ProductServiceImpl productService;

    @PostMapping("/add_product_category")
    public String addProductCategory(String name){
        productCategoryService.createProductCategory(name);
        log.info("Создана категория: " + name);
        return "redirect:/product_category/";
    }

    @PostMapping("/add_product_subcategory")
    public String addProductSubCategory(String name,Long productCategoryId){
        productSubCategoryService.createProductSubCategory(name,productCategoryId);
        log.info("Создана подкатегория: " + name);
        return "redirect:/product_subcategory/" + productCategoryId;
    }

    @PostMapping("/add_product")
    public String addProduct(String name,Long productSubCategoryId){
        productService.createProduct(name,productSubCategoryId);
        log.info("Создан продукт: " + name);
        return "redirect:/products/" + productSubCategoryId;
    }
}
