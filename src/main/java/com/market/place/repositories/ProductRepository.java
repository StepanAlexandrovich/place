package com.market.place.repositories;

import com.market.place.models.Basket;
import com.market.place.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
//    @Query(value = "select id, name, product_sub_category_id from public.products as p, public.baskets_products as bp\n" +
//            "where bp.product_id = p.id and bp.basket_id = :basketId",nativeQuery = true)
//    List<Product> findByBasketId(Long basketId);

    //List<Product> findByBasket(Basket basket);
}
