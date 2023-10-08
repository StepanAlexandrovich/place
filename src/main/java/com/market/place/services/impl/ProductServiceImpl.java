package com.market.place.services.impl;

import com.market.place.models.Product;
import com.market.place.models.ProductSubCategory;
import com.market.place.repositories.ProductRepository;
import com.market.place.repositories.ProductSubCategoryRepository;
import com.market.place.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductSubCategoryRepository productSubCategoryRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(new Product());
    }

    @Override
    public List<Product> getAllByBasketId(Long basketId) {
        return productRepository.findByBasketId(basketId);
    }

    @Override
    public void createProduct(String name,Long productSubCategoryId) {
        ProductSubCategory productSubCategory = productSubCategoryRepository.findById(productSubCategoryId).orElse(new ProductSubCategory());

        Product product = new Product();
        product.setName(name);
        product.setProductSubCategory(productSubCategory);

        productRepository.save(product);
    }
}
