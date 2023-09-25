package com.example.useremployee.DTO;

import com.example.useremployee.useremployee.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User toEntity(UserDTO userDTO) {
        return new User(
        userDTO.userID(),
        userDTO.email(),
        userDTO.password());

    }


    public UserDTO userDTO (User user) {
        return new UserDTO(
                user.getUserID(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
