package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOError;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello stranger, welcome to this API";
    }


    @GetMapping("/addStudentToDB")
    public String addStudentToDB() throws IOError {
        Student student = new Student(1,"John",23,true,"OsloMet");
        Student student2 = new Student(2,"Ole",24,false,"Harvard");
        Student student3 = null;
        try{
            studentRepository.save(student);
            studentRepository.save(student2); /// INSERT INTO student VALUES (? ? ? ?
            studentRepository.save(student3);
            return "Success - Student added";
        }catch (Exception e){
            System.out.println();
            return "No success there has been an error - Student added";
        }
    }

    @GetMapping("/getStudentsFromDB")
    public String getStudentsFromDB(){
        List<Student> studentList = studentRepository.findAllByOrderByNameAsc();  // SELECT * from students
        studentList.forEach(x-> System.out.println(x));
        return "Students retrived - check Java console";
    }

    @DeleteMapping("/deleteStudentsFromDB")
    public String deleteStudentsFromDB(){
         studentRepository.deleteAll();
         return "Students deleted";
    }

    @PostMapping("/setStudentDB")
    public String setStudentDB(@RequestBody Student student){
        System.out.println(student);
        studentRepository.save(student);
        return "Object was received... we are goind to process it (somehow)";
    }

    @PutMapping("/updateStudentDB")
    public String updateStudentDB(@RequestParam Long id,  @RequestParam String name){
        Student student = studentRepository.getById(id);
        student.setName(name);
        studentRepository.save(student);
        return "updated";
    }
};


