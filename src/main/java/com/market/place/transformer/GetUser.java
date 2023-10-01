package com.market.place.transformer;

import com.market.place.models.User;

public interface GetUser<T extends User> {
    T getUser();
}
