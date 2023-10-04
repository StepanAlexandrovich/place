package com.market.place.services;

import com.market.place.models.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getAll();

    void createProductCategory(String name);
}
