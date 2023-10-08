package com.market.place.services;

import com.market.place.models.ProductSubCategory;

import java.util.List;

public interface ProductSubCategoryService {
    List<ProductSubCategory> getAll();
    List<ProductSubCategory> getAllByProductCategoryId(Long id);
    void createProductSubCategory(String name,Long productCategoryId);
    ProductSubCategory getById(Long productCategoryId);

}
