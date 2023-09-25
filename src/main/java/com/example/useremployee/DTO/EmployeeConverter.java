package com.example.useremployee.DTO;
import com.example.useremployee.useremployee.model.Employee;
import org.springframework.stereotype.Component;
@Component
public class EmployeeConverter {

    public Employee toEntity(EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.gender(),
        employeeDTO.born(),
        employeeDTO.vegetarian(),
        employeeDTO.name(),
        employeeDTO.user()
        );
    }

    public EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getGender(),
                employee.getBorn(),
                employee.isVegetarian(),
                employee.getName(),
                employee.getUser()
        );
    }


}

