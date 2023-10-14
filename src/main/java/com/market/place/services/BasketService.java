package com.market.place.services;

import com.market.place.models.Basket;
import com.market.place.models.Product;
import com.market.place.models.User;

import java.util.List;

public interface BasketService {
    List<Basket> getAll();
    Basket getById(Long id);
    void createBasket(String name);
    void createBasket(String name, User user);

    List<Basket> getAllByUserId(Long userId);

    void addProduct(Long productId,Long basketId);
}
