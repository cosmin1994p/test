package com.example.demo;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("/hello")
    public String hello(){
        // one more example of how we can access the "session" object and see (or edit if we want) information that exists inside
        String obj = "this student has visited the /hello endpoint";
        session.setAttribute("hello",obj);
        return "Hello stranger, welcome to this API" +
                "   .The following user logged in earlier: "
                + session.getAttribute("Logged in").toString();
    }
    @GetMapping("/goodbye")
    public String goodbye(){
        // if there is no need for a session, than we can go ahead and just remove it. once we do that, we can no longer access the info inside
        session.invalidate();
        return "Session invalidated";
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
    public String updateStudentDB(@RequestParam Integer id,  @RequestParam String name){
        Student student = studentRepository.getById(id);
        student.setName(name);
        studentRepository.save(student);
        return "updated";
    }
    @PostMapping("/updateStudentDBPost")
    public String updateStudentDBPost(@RequestParam Integer id,  @RequestParam String name,
                                      @RequestParam Integer age, @RequestParam String univ){

        Student student = studentRepository.getById(id);
        if(name!=null){
            student.setName(name);
        }
        if(age!=null){
            student.setAge(age);
        }
        if(univ!=null){
            student.setUniv(univ);
        }
        studentRepository.save(student);
        return "updated";
    }


    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam Integer id){
        studentRepository.deleteById(id);
        return "The student with the id: " + id + "has been deleted";
    }

    @GetMapping("/getStudentHardCoded")
    public Collection<Student> getStudentHardCoded() throws IOError {
        Collection<Student> studs = new ArrayList<>();
        Student student = new Student(1,"John",23,true,"OsloMet");
        Student student2 = new Student(2,"Ole",24,false,"Harvard");
        studs.add(student);
        studs.add(student2);
        return studs;
    }
};


