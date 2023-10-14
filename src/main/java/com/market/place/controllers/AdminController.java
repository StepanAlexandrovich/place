package com.market.place.controllers;

import com.market.place.models.ProductCategory;
import com.market.place.services.impl.ProductCategoryServiceImpl;
import com.market.place.services.impl.ProductServiceImpl;
import com.market.place.services.impl.ProductSubCategoryServiceImpl;
import com.market.place.validation.ProductCategoryValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@Slf4j
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    private final ProductCategoryServiceImpl productCategoryService;
    private final ProductSubCategoryServiceImpl productSubCategoryService;
    private final ProductServiceImpl productService;

    private final ProductCategoryValidation productCategoryValidation;



//    @PostMapping("/add_product")
//    public String addProduct(String name, Long productSubCategoryId, @RequestParam MultipartFile file1,@RequestParam MultipartFile file2,@RequestParam MultipartFile file3){  // переделать
//        List<MultipartFile> files = new ArrayList<>();
//        files.add(file1);
//        files.add(file2);
//        files.add(file3);
//
//        productService.createProduct(name,productSubCategoryId,files);
//        log.info("Создан продукт: " + name);
//
//        return "redirect:/menu/products/product_category/product_subcategory/products/" + productSubCategoryId; //перед
//    }
}
