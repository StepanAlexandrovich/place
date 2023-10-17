package com.market.place.controllers.distributor;

import com.market.place.models.Product;
import com.market.place.models.ProductCategory;
import com.market.place.models.ProductSubCategory;
import com.market.place.services.impl.ProductCategoryServiceImpl;
import com.market.place.services.impl.ProductServiceImpl;
import com.market.place.services.impl.ProductSubCategoryServiceImpl;
import com.market.place.validation.ProductCategoryValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("distributor/menu/product_category")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_DISTRIBUTOR')")
public class DistributorProductsController {
    private final ProductCategoryServiceImpl productCategoryService;
    private final ProductSubCategoryServiceImpl productSubCategoryService;
    private final ProductServiceImpl productService;
    private final ProductCategoryValidation productCategoryValidation;
    
    @GetMapping("")
    public String getAllCategory(Model model){
        List<ProductCategory> productCategories = productCategoryService.getAll();
        model.addAttribute("productCategories",productCategories);
        return "distributor/products_folder/product_category";
    }

    @GetMapping("/product_sub_category/{productCategoryId}")
    public String getProductSubCategoryByProductCategoryId(@PathVariable Long productCategoryId, Model model){
        ProductCategory productCategory = productCategoryService.getById(productCategoryId);
        model.addAttribute("productCategory",productCategory);
        return "distributor/products_folder/product_sub_category";
    }

    @GetMapping("/product_sub_category/products/{productSubCategoryId}")
    public String getProductsByProductSubCategoryId(@PathVariable Long productSubCategoryId, Model model){
        ProductSubCategory productSubCategory = productSubCategoryService.getById(productSubCategoryId);
        model.addAttribute("productSubCategory",productSubCategory);
        return "distributor/products_folder/products";
    }

    @GetMapping("/product_sub_category/products/product/{productId}")
    public String getProductById(@PathVariable Long productId, Model model){
        Product product = productService.getById(productId);
        model.addAttribute("product",product);
        return "distributor/products_folder/product";
    }

    @PostMapping("/product_sub_category/products/add_product")
    public String addProduct(String name, Long productSubCategoryId,
                             @RequestParam MultipartFile file1,
                             @RequestParam MultipartFile file2,
                             @RequestParam MultipartFile file3,
                             Model model
    ){  // переделать
        List<MultipartFile> files = new ArrayList<>();
        files.add(file1);
        files.add(file2);
        files.add(file3);

        productService.createProduct(name,productSubCategoryId,files);

        return getProductsByProductSubCategoryId(productSubCategoryId,model);
    }

}
