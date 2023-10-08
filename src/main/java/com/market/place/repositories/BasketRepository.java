package com.market.place.repositories;

import com.market.place.models.Basket;
import com.market.place.models.ProductSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket,Long> {
    @Query(value = "SELECT * FROM public.baskets where user_id = :userId",nativeQuery = true)
    List<Basket> findAllByUserId(Long userId);
}
