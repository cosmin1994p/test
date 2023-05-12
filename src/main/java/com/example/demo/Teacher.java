package com.example.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue()
    private Integer id;
    private String name;
    private String specialty;

    public Teacher(String name, String specialty, University university) {
        this.name = name;
        this.specialty = specialty;
    }

    public Teacher(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }
}
