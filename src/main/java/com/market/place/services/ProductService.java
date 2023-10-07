package com.market.place.services;

import com.market.place.models.Product;
import com.market.place.models.ProductCategory;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(Long id);
    void createProduct(String name,Long productSubCategoryId);
}
