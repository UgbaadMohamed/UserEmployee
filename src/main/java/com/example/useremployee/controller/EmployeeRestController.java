package com.example.useremployee.controller;
import com.example.useremployee.DTO.EmployeeConverter;
import com.example.useremployee.DTO.EmployeeDTO;
import com.example.useremployee.DTO.UserConverter;
import com.example.useremployee.DTO.UserDTO;
import com.example.useremployee.repository.EmployeeRepository;
import com.example.useremployee.repository.UserRepository;
import com.example.useremployee.useremployee.model.Employee;
import com.example.useremployee.useremployee.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeRestController {

   @Autowired
    EmployeeRepository employeeRepository;

   @Autowired
   private final UserRepository userRepository;

   @Autowired
   EmployeeConverter employeeConverter;


    @Autowired
    UserConverter userConverter;

    public EmployeeRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO postEmployee (@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeConverter.toEntity(employeeDTO);
        employee.setId(0);
        employeeRepository.save(employee);
        System.out.println(employee);
        return employeeConverter.toDTO(employee);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        userList.forEach(u ->{
            userDTOList.add(userConverter.userDTO(u));
        });
        return userDTOList;
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO postUser (@RequestBody UserDTO userDTO) {
        User user = userConverter.toEntity(userDTO);
        user.setUserID(0);
        userRepository.save(user);
        System.out.println(user);
        return userConverter.userDTO(user);
    }



    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> putStudent(@PathVariable("id") int id, @RequestBody UserDTO userDTO) {
        Optional<User> studentOptional = userRepository.findById(id);
        if (studentOptional.isPresent()) {
            User user = userConverter.toEntity(userDTO);
            user.setUserID(id);
            userRepository.save(user);
            return ResponseEntity.ok(userConverter.userDTO(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    //this ca
    @DeleteMapping("user/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
        Optional<   User> studentOptional = userRepository.findById(id);
        if(studentOptional.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted");
        }
        else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("The user was not found");
        }

    }


}
