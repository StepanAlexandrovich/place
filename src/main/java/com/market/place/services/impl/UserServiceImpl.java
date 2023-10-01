package com.market.place.services.impl;

import com.market.place.dto.UserCreateDto;
import com.market.place.models.User;
import com.market.place.repositories.UserRepository;
import com.market.place.repositories.UserRoleRepository;
import com.market.place.services.UserService;
import com.market.place.transformer.UserCreateDtoToUserTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserCreateDtoToUserTransformer<User> userCreateDtoToUserTransformer;

    @Override
    public void createUser(UserCreateDto userCreateDto) {
        User user = userCreateDtoToUserTransformer.transform(userCreateDto);
        user.setUserRole(userRoleRepository.findByRole("ROLE_USER"));
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
