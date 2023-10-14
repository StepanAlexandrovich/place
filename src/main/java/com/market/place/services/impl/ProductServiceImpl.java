package com.market.place.services.impl;

import com.market.place.models.BasketProduct;
import com.market.place.models.Image;
import com.market.place.models.Product;
import com.market.place.models.ProductSubCategory;
import com.market.place.repositories.BasketProductRepository;
import com.market.place.repositories.BasketRepository;
import com.market.place.repositories.ProductRepository;
import com.market.place.repositories.ProductSubCategoryRepository;
import com.market.place.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductSubCategoryRepository productSubCategoryRepository;
    private final BasketRepository basketRepository;
    private final BasketProductRepository basketProductRepository;

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
        // не бинится
        //Basket basket = basketRepository.findById(basketId).orElse(null);// подумать над валидацией
        //return productRepository.findByBasket(basket);

        List<BasketProduct> basketProducts = basketProductRepository.findByBasketId(basketId);
        List<Product> products = new ArrayList<>();
        for (BasketProduct basketProduct : basketProducts) {
            products.add(basketProduct.getProduct());
        }
        return products;
    }

    @Override
    public void createProduct(String name, Long productSubCategoryId, List<MultipartFile> files) {
        ProductSubCategory productSubCategory = productSubCategoryRepository.findById(productSubCategoryId).orElse(new ProductSubCategory());

        // упростить
        List<Image> images = new ArrayList<>();
        for (MultipartFile file : files) {
            Image image = convert(file);
            images.add(image);
        }

        Product product = new Product();
        product.setName(name);
        product.setProductSubCategory(productSubCategory);

        for (Image image : images) {
            image.setProduct(product);
        }

        product.setImages(images);
        productRepository.save(product);
    }

    private Image convert(MultipartFile file){
        Image image = new Image();

        try {
            image.setName(file.getName());
            image.setSize(file.getSize());
            image.setBytes(file.getBytes());
            image.setOriginalFileName(file.getOriginalFilename());
            image.setContentType(file.getContentType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return image;
    }
}
