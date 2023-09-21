package com.market.place.services.impl;

import com.market.place.dto.UserCreateDto;
import com.market.place.models.User;
import com.market.place.repositories.UserRepository;
import com.market.place.repositories.UserRoleRepository;
import com.market.place.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    @Override
    public void createUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setLogin(userCreateDto.getLogin());
        user.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        user.setUserRole(userRoleRepository.findByRole("ROLE_USER"));
        user.setBan(false);
        userRepository.save(user);
    }
}
