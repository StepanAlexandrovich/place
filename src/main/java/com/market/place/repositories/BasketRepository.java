package com.market.place.repositories;

import com.market.place.models.Basket;
import com.market.place.models.ProductSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket,Long> {
    @Query(value = "SELECT * FROM public.product_sub_category where product_category_id = :productCategoryId",nativeQuery = true)
    List<ProductSubCategory> findAllByProductCategoryId(Long productCategoryId);

    @Query(value = "SELECT * FROM public.basket where user_id = :userId",nativeQuery = true) // исп basket на baskets
    List<Basket> findAllByUserId(Long userId);
}
