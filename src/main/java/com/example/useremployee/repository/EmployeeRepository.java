package com.example.useremployee.repository;

import com.example.useremployee.useremployee.model.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //dette finder alle de medarbjeder der er i initdata og printer dem ud....
    List<Employee> findEmployeeByName(String name);
}
