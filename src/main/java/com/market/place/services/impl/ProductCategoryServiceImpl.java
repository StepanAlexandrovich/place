package com.market.place.services.impl;

import com.market.place.models.ProductCategory;
import com.market.place.repositories.ProductCategoryRepository;
import com.market.place.services.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;


    @Override
    public List<ProductCategory> getAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory getById(Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id).orElse(null);
        if(productCategory == null){
            log.info("по id ничего не найдено");
        }else{
            log.info("создан новый productCategory");
        }
        return productCategory;

        //return productCategoryRepository.findById(id).orElse(new ProductCategory());
    }

    @Override
    public void createProductCategory(String name) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(name);
        productCategoryRepository.save(productCategory);
    }
}
