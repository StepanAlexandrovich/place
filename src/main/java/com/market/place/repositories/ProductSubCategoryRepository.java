package com.market.place.repositories;

import com.market.place.models.ProductCategory;
import com.market.place.models.ProductSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory,Long> {
    @Query(value = "SELECT * FROM public.product_sub_category where product_category_id = :productCategoryId",nativeQuery = true)
    List<ProductSubCategory> findAllByProductCategoryId(Long productCategoryId);

    Optional<ProductSubCategory> findByName(String name);
}
