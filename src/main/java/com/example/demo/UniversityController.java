package com.example.demo;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UniversityController {

    //  Here we use dependency injection to add the HttpSession object. At first it will be of course empty.
    @Autowired
    private HttpSession session;


    Logger logger = LoggerFactory.getLogger(UniversityController.class);


    List<University> universityList = new ArrayList<University>();

    @GetMapping("/getUniversityList")
    public List<University> createHardCodedList(){
        universityList.add(new University("OsloMet","Norway"));
        universityList.add(new University("CSIE","Romania"));
        universityList.add(new University("Harvard","USA"));
        universityList.add(new University("MIT","USA"));
        return universityList;
    }

    @GetMapping("/createSession")
    public String createSession(){
        //once the endpoint is activated, the session object will receive a new attribute created by us: "Logged in"
        Student student = new Student(1,"John",24); // the attribute will receive the value of this new student
        session.setAttribute("Logged in", student);
        logger.info("Student " + student.getName() + " logged in");
        return "Session created";
    }

    @GetMapping("/seeSession")
    public String seeSession(){
        //once we added our student in the session obj ("John") he will be available wherever we need it via this session object
        // you can imagine that "session' is just a box that we can access on multiple parts of our project and we can add and
        //remove information as we like!
        return session.getAttribute("Logged in").toString();
    }



}
