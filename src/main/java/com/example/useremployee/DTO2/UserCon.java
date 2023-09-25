package com.example.useremployee.DTO2;

import com.example.useremployee.DTO.UserDTO;
import com.example.useremployee.useremployee.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserCon {

    //get
        public User toEntity(UsDTO userDTO) {
            return new User(
                    userDTO.userID(),
                    userDTO.email(),
                    userDTO.password());

        }

        // post og update
        public UsDTO usDTO (User user) {
            return new UsDTO(
                    user.getUserID(),
                    user.getEmail(),
                    user.getPassword()
            );
        }
    }

