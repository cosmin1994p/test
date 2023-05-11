package com.example.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "university")
@Data
@AllArgsConstructor
public class University {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String country;
    @OneToMany
    private List<Teacher> teacherList;

    public University(){}

    public University(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public University(String name, String country, List<Teacher> teachers) {
        this.name = name;
        this.country = country;
        this.teacherList = teachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
