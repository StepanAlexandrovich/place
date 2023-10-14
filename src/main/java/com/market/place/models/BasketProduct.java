package com.market.place.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "baskets_products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BasketProduct {
    @EmbeddedId
    BasketProductKey id;

    @ManyToOne
    @MapsId("basketId")
    @JoinColumn(name = "basket_id")
    Basket basket;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    @Column(name = "products_count")
    private Long productsCount;
}
