package com.market.place.services;

import com.market.place.dto.UserCreateDto;
import com.market.place.models.User;

import java.util.List;

public interface UserService {
    void createUser(UserCreateDto userCreateDto);

    List<User> getAll();
}
