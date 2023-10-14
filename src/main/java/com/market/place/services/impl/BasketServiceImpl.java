package com.market.place.services.impl;

import com.market.place.models.*;
import com.market.place.repositories.BasketProductRepository;
import com.market.place.repositories.BasketRepository;
import com.market.place.repositories.ProductRepository;
import com.market.place.services.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final ProductRepository productRepository;

    private final BasketProductRepository basketProductRepository;

    @Override
    public List<Basket> getAll() {
        return basketRepository.findAll();
    }

    @Override
    public Basket getById(Long id) {
        return basketRepository.findById(id).orElse(new Basket());
    }

    @Override
    public void createBasket(String name) {
        Basket basket = new Basket();
        basket.setName(name);
        basketRepository.save(basket);
    }

    @Override
    public void createBasket(String name, User user) {
        Basket basket = new Basket();
        basket.setName(name);
        basket.setUser(user);
        basketRepository.save(basket);
    }

    @Override
    public List<Basket> getAllByUserId(Long userId) {
        return basketRepository.findAllByUserId(userId);
    }

    @Override
    public void addProduct(Long productId, Long basketId) {
        BasketProductKey key = new BasketProductKey(basketId, productId);
        BasketProduct basketProduct = basketProductRepository.findById(key).orElse(null);
        if(basketProduct == null){

            Basket basket = basketRepository.findById(key.getBasketId()).orElse(null);
            Product product = productRepository.findById(key.getProductId()).orElse(null);
            if(basket!=null && product!=null){
                basketProduct = new BasketProduct(key,basket,product,1L);
            }else{
                System.out.println("Продукт или карзина с такими id не найдены");
            }
        }else{
            Long productsCount = basketProduct.getProductsCount();
            basketProduct.setProductsCount(productsCount + 1);
        }

        basketProductRepository.save(basketProduct);
    }


}
