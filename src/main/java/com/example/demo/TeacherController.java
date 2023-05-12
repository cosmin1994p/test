package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    UniversityRepository universityRepository;

    @GetMapping("/setTeacherUniv")
    public String setTeacherUniv(){
        Teacher teacher2 = new Teacher("Anne","Python");
        Teacher teacher1 = new Teacher("John","Web Dev");
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);
        teacherRepository.saveAll(teachers);
        University university = new University("OsloMet","Norway", teachers);
        universityRepository.save(university);
        return "Teachers and universities added to the DB";
    }

    @GetMapping("/getTeachersBasedOnUniv")
    public String getTeachersBasedOnUniv(){
        List<University> universities = universityRepository.findAll();
        universities.get(0).getTeacherList().forEach(System.out::println);
        return "Teachers returned based on the db";
    }

    @PostMapping("/saveTeacherDTO")
    public String saveTeacherDTO(@RequestBody TeacherDTO teacherDTO){
        System.out.println(teacherDTO.toString());
        Teacher teacher = new Teacher(teacherDTO.getTeacherName(),teacherDTO.getSpeciality());
        teacherRepository.save(teacher);
        University university = new University(teacherDTO.getUnivName(),teacherDTO.getUnivCountry());
        universityRepository.save(university);
        return "";
    }
}
