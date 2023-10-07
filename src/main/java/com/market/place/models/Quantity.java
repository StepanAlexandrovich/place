package com.market.place.models;

import com.market.place.enums.ReasonChangeQuantity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "quantities")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Quantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "change_value")
    private Double changeValue;
    @Column(name = "rest_value")
    private Double restValue;
    @Column(name = "date")
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private ReasonChangeQuantity reasonChangeQuantity;
    @Column(name = "previous_id")
    private Long previousId;
    @Column(name = "next_id")
    private Long nextId;

    @ManyToOne
    private Product product;
}
