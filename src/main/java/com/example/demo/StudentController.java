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

    Logger logger = LoggerFactory.getLogger(StudentController.class);
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
            logger.error(e.getMessage());
            return e.getStackTrace().toString();
        }
    }

        @GetMapping("/getStudentsFromDB")
    public List<Student> getStudentsFromDB(){
        List<Student> studentList = studentRepository.findAllByOrderByNameAsc();  // SELECT * from students
        studentList.forEach(x-> System.out.println(x));
        return studentList;
    }

    @DeleteMapping("/deleteStudentsFromDB")
    public String deleteStudentsFromDB(){
         studentRepository.deleteAll();
         return "Students deleted";
    }

    @PostMapping("/setStudentDB")
    public String setStudentDB(@RequestBody Student student){
        logger.info(String.valueOf(student));
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
    @PostMapping("/updateStudentDBPost")
    public String updateStudentDBPost(@RequestParam Long id,  @RequestParam String name){
        Student student = studentRepository.getById(id);
        student.setName(name);
        studentRepository.save(student);
        return "updated";
    }


    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam Long id){
        studentRepository.deleteById(id);
        return "The student with the id: " + id + "has been deleted";
    }
};


