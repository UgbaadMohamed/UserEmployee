package com.example.useremployee.DTO2;
import com.example.useremployee.DTO.EmployeeDTO;
import com.example.useremployee.useremployee.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployCon {
    public Employee toEntity(EmployeeDTO employDTO) {
        return new Employee(
                employDTO.name(),
                employDTO.user()
                );
    }

    public EmployDTO toDTO(Employee employee) {
        return new EmployDTO(
                employee.getName(),
                employee.getUser()
        );
    }
}
