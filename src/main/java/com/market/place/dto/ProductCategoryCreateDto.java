package com.market.place.dto;

import com.market.place.models.Price;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryCreateDto {
    private String name;
    private Price price;
}
