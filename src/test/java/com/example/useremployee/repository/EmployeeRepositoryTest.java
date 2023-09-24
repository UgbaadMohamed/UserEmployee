package com.example.useremployee.repository;

import com.example.useremployee.useremployee.model.Employee;
import org.hibernate.exception.JDBCConnectionException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void testJFJDFHexsist() {

      List<Employee> lst = employeeRepository.findEmployeeByName("JFJDFH");
      assertTrue(lst.size() > 0);
    }

    @Test
    public void testDelteeEmployee() {
        List<Employee> lst = employeeRepository.findEmployeeByName("JFJDFH");
        Employee emp1 = lst.get(0);
     //   userRepository.delete(emp1.ge);
       // assertThrows(DataIntegrityViolationException.class,() -> userRepository.delete(emp1.getUser()));
    }
}