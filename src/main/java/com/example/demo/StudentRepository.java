package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    // get all student < 21 and name like "%o%"   => SELECT * FROM STUDENTS WHERE AGE > 21 AND NAME LIKE "%o%"
    public List<Student> findStudentByAgeBeforeAndNameLike(Integer age,String name);

    public List<Student> findDistinctByName(String name);

    public List<Student> findAllByOrderByNameAsc();


    @Query("select s from Student s where s.name = ?1")
    List<Student> getStudents(String name);

}
