package com.market.place.services;

import com.market.place.models.Product;
import com.market.place.models.ProductCategory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(Long id);
    List<Product> getAllByBasketId(Long basketId);
    void createProduct(String name, Long productSubCategoryId, List<MultipartFile> file);
}
