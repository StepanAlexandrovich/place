package com.market.place.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    private ProductSubCategory productSubCategory;
    @OneToMany(mappedBy = "product")
    private List<Price> prices = new ArrayList<>();
    @OneToMany(mappedBy = "product")
    private List<Quantity> quantities = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    Set<BasketProduct> basketProducts;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Image> images = new ArrayList<>();
}
