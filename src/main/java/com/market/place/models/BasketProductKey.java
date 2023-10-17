package com.market.place.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class BasketProductKey implements Serializable {
    @Column(name = "basket_id")
    private Long basketId;
    @Column(name = "product_id")
    private Long productId;

    public BasketProductKey() {
    }

    public BasketProductKey(Long basketId, Long productId) {
        this.basketId = basketId;
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketProductKey that = (BasketProductKey) o;
        return Objects.equals(basketId, that.basketId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basketId, productId);
    }
}
