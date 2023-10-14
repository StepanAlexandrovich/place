package com.market.place.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "distributors")
@NoArgsConstructor
public class Distributor extends User{
    public Distributor(User user) {
        super(user.getId(), user.getLogin(), user.getPassword(), user.getBan(),user.getUserRole(),user.getBaskets());
    }

    @Column(name = "name")
    private String name;
}
