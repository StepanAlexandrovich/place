package com.market.place.services.impl;

import com.market.place.models.ProductCategory;
import com.market.place.models.ProductSubCategory;
import com.market.place.repositories.ProductCategoryRepository;
import com.market.place.repositories.ProductSubCategoryRepository;
import com.market.place.services.ProductSubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSubCategoryServiceImpl implements ProductSubCategoryService {
    private final ProductSubCategoryRepository productSubCategoryRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductSubCategory> getAll() {
        return productSubCategoryRepository.findAll();
    }

    @Override
    public List<ProductSubCategory> getAllByProductCategoryId(Long id) {
        return productSubCategoryRepository.findAllByProductCategoryId(id);
    }

    @Override
    public void createProductSubCategory(String name, Long productCategoryId) {
        ProductCategory productCategory = productCategoryRepository.findById(productCategoryId).orElse(new ProductCategory());

        ProductSubCategory productSubCategory = new ProductSubCategory();
        productSubCategory.setName(name);
        productSubCategory.setProductCategory(productCategory);

        productSubCategoryRepository.save(productSubCategory);
    }

    @Override
    public ProductSubCategory getById(Long productCategoryId) {
        return productSubCategoryRepository.findById(productCategoryId).orElse(new ProductSubCategory());
    }


}
