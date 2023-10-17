package com.market.place.controllers.admin;

import com.market.place.models.Product;
import com.market.place.models.ProductCategory;
import com.market.place.models.ProductSubCategory;
import com.market.place.services.impl.ProductCategoryServiceImpl;
import com.market.place.services.impl.ProductServiceImpl;
import com.market.place.services.impl.ProductSubCategoryServiceImpl;
import com.market.place.validation.ProductCategoryValidation;
import com.market.place.validation.ProductSubCategoryValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin/menu/product_category")
@RequiredArgsConstructor
@Slf4j
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminProductsController {
    private final ProductCategoryServiceImpl productCategoryService;
    private final ProductSubCategoryServiceImpl productSubCategoryService;
    private final ProductServiceImpl productService;
    private final ProductCategoryValidation productCategoryValidation;
    private final ProductSubCategoryValidation productSubCategoryValidation;

    @GetMapping("")
    public String getAllCategory(Model model){
        model.addAttribute("productCategories",productCategoryService.getAll());
        model.addAttribute("productCategory",new ProductCategory());
        return "admin/products_folder/product_category";

    }
    @PostMapping("/add_product_category")
    public String addProductCategory(@ModelAttribute("productCategory") ProductCategory productCategory, BindingResult bindingResult, Model model){
        productCategoryValidation.validate(productCategory,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("productCategories",productCategoryService.getAll());
            return "admin/products_folder/product_category";
        }
        productCategoryService.createProductCategory(productCategory.getName());
        return getAllCategory(model);
    }

    //--------------------------------------------
    @GetMapping("/product_sub_category/{productCategoryId}")
    public String getProductSubCategoryByProductCategoryId(@PathVariable Long productCategoryId, Model model){
        model.addAttribute("productCategory",productCategoryService.getById(productCategoryId));
        model.addAttribute("productSubCategory",new ProductSubCategory());
        return "admin/products_folder/product_sub_category";
    }
    @PostMapping("/product_sub_category/add_product_sub_category")
    public String addProductSubCategory(Long productCategoryId,ProductSubCategory productSubCategory,BindingResult bindingResult,Model model){
        productSubCategoryValidation.validate(productSubCategory,bindingResult);
        if(bindingResult.hasErrors()){
            ProductSubCategory newP = new ProductSubCategory();
            newP.setName("подкатегория существует");
            model.addAttribute("productSubCategory",newP);
            model.addAttribute("productCategory",productCategoryService.getById(productCategoryId));
            return "admin/products_folder/product_sub_category";
        }

        productSubCategoryService.createProductSubCategory(productSubCategory.getName(),productCategoryId);  // сделать валидацию
        return getProductSubCategoryByProductCategoryId(productCategoryId,model);
    }
    //------------------------------------------
    @GetMapping("/product_sub_category/products/{productSubCategoryId}")
    public String getProductsByProductSubCategoryId(@PathVariable Long productSubCategoryId, Model model){
        ProductSubCategory productSubCategory = productSubCategoryService.getById(productSubCategoryId);
        model.addAttribute("productSubCategory",productSubCategory);
        return "admin/products_folder/products";
    }
    @GetMapping("/product_sub_category/products/product/{productId}")
    public String getProductById(@PathVariable Long productId, Model model){
        Product product = productService.getById(productId);
        model.addAttribute("product",product);
        return "admin/products_folder/product";
    }

}
