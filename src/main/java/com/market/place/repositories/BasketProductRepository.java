package com.market.place.repositories;

import com.market.place.models.BasketProduct;
import com.market.place.models.BasketProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BasketProductRepository extends JpaRepository<BasketProduct, BasketProductKey>{
    @Query(value = "SELECT * FROM public.baskets_products where basket_id = :basketId",nativeQuery = true)
    List<BasketProduct> findByBasketId(Long basketId);
}
