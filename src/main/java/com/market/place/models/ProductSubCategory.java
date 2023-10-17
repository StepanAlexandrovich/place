package com.market.place.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_sub_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductSubCategory implements Name{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    private ProductCategory productCategory;
    @OneToMany(mappedBy = "productSubCategory")
    private List<Product> products = new ArrayList<>();
}
