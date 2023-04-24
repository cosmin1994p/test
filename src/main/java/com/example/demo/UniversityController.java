package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UniversityController {
    List<University> universityList = new ArrayList<University>();

    @GetMapping("/getUniversityList")
    public List<University> createHardCodedList(){
        universityList.add(new University("OsloMet","Norway"));
        universityList.add(new University("CSIE","Romania"));
        universityList.add(new University("Harvard","USA"));
        universityList.add(new University("MIT","USA"));
        return universityList;
    }



}
