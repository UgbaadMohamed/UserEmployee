package com.example.useremployee.useremployee.model;

import com.example.useremployee.DTO.UserDTO;
import com.example.useremployee.useremployee.model.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private LocalDateTime born;
    private Gender gender;
    private boolean vegetarian;

    @OneToOne
    @JoinColumn(name = "useridfk", referencedColumnName = "userID", nullable = false)
    private User user;

    public Employee (Gender gender, LocalDateTime born, boolean vegetarian, String name,User user ) {
        this.gender = gender;
        this.born= born;
        this.vegetarian=vegetarian;
        this.name=name;
        this.user=user;
    }
    public Employee(String name,User user) {
        this.name = name;
        this.user=user;
    }

    public Employee() {

    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBorn() {
        return born;
    }

    public void setBorn(LocalDateTime born) {
        this.born = born;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
}
