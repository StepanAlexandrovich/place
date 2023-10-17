package com.market.place.transformer;

import com.market.place.dto.UserCreateDto;
import com.market.place.models.User;
import com.market.place.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Setter
public class UserCreateDtoToUserTransformer<T extends User> extends Transformer<User, UserCreateDto>{
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User transform(UserCreateDto userCreateDto) {
        User user = new User();

        user.setLogin(userCreateDto.getLogin());
        user.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));

        user.setBan(false);
        return user;
    }
}
