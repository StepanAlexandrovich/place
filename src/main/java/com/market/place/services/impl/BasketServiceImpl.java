package com.market.place.services.impl;

import com.market.place.models.Basket;
import com.market.place.models.Product;
import com.market.place.models.User;
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
        Basket basket = basketRepository.findById(basketId).orElse(new Basket());
        basket.getProducts().add(productRepository.findById(productId).orElse(new Product()));
        basketRepository.save(basket);
    }


}
