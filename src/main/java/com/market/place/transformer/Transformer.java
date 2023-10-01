package com.market.place.transformer;

public abstract class Transformer <T,E>{
    public abstract T transform(E e);
}
