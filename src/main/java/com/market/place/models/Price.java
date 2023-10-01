package com.market.place.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "prices")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "value")
    private Double value;
    @Column(name = "last")
    private Boolean last;
    @ManyToOne
    private Product product;
}
