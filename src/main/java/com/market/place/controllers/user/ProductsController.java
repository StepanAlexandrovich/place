package com.market.place.controllers.user;

import com.market.place.models.Product;
import com.market.place.models.ProductCategory;
import com.market.place.models.ProductSubCategory;
import com.market.place.services.impl.ProductCategoryServiceImpl;
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
import java.util.List;

@Controller
@RequestMapping("user/menu/product_category")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductCategoryServiceImpl productCategoryService;
    private final ProductSubCategoryServiceImpl productSubCategoryService;
    private final ProductServiceImpl productService;
    @GetMapping("")
    public String getAllCategory(Model model, Principal principal){
        String role = ((UsernamePasswordAuthenticationToken) principal).getAuthorities().stream().toList().get(0).getAuthority();

        List<ProductCategory> productCategories = productCategoryService.getAll();
        model.addAttribute("productCategories",productCategories);
        model.addAttribute("userRole",role);
        return "user/products_folder/product_category";
    }
    @GetMapping(value = "/product_subcategory/{productCategoryId}")
    public String getSubCategoriesByProductCategoryId(@PathVariable Long productCategoryId,Model model, Principal principal){
        String role = ((UsernamePasswordAuthenticationToken) principal).getAuthorities().stream().toList().get(0).getAuthority();
        ProductCategory productCategory = productCategoryService.getById(productCategoryId);

        model.addAttribute("productSubCategories",productCategory.getProductSubCategories());
        model.addAttribute("productCategory",productCategory);
        model.addAttribute("userRole",role);

        return "user/products_folder/product_sub_category";
    }

    @GetMapping("/product_sub_category/products/{productSubCategoryId}")
    public String getProductsByProductSubCategoryId(@PathVariable Long productSubCategoryId, Model model){
        ProductSubCategory productSubCategory = productSubCategoryService.getById(productSubCategoryId);
        model.addAttribute("productSubCategory",productSubCategory);
        return "user/products_folder/products";
    }
    @GetMapping("/product_sub_category/products/product/{productId}")
    public String getProductById(@PathVariable Long productId, Model model){
        Product product = productService.getById(productId);
        model.addAttribute("product",product);
        return "user/products_folder/product";
    }

}
