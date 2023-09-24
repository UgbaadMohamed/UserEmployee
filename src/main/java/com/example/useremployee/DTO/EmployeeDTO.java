package com.example.useremployee.DTO;
import com.example.useremployee.useremployee.model.Gender;
import com.example.useremployee.useremployee.model.User;

import java.time.LocalDateTime;

public record EmployeeDTO(Gender gender, LocalDateTime born, boolean vegetarian, String name,User user) {
}
