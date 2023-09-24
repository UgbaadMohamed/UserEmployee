package com.example.useremployee.config;
import com.example.useremployee.repository.EmployeeRepository;
import com.example.useremployee.repository.UserRepository;
import com.example.useremployee.useremployee.model.Employee;
import com.example.useremployee.useremployee.model.Gender;
import com.example.useremployee.useremployee.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("bjar@aol.com", "1234"));
        User us1 = userRepository.save(new User("ann@aol.com", "abcd"));
        userRepository.save(new User("i@google.com", "password"));

        Employee emp1 = new Employee();
        emp1.setName("Anna");
        emp1.setGender(Gender.FEMALE);
        emp1.setVegetarian(false);
        emp1.setBorn(LocalDateTime.of(2000,1,1,7,55,0));
        emp1.setUser(us1);
        employeeRepository.save(emp1);
    }
}
