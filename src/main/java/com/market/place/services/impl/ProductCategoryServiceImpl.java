package com.market.place.services.impl;

import com.market.place.models.ProductCategory;
import com.market.place.repositories.ProductCategoryRepository;
import com.market.place.services.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public void createProductCategory(String name) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(name);
        productCategoryRepository.save(productCategory);
    }
}
