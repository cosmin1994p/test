package miscelanious;

import com.example.demo.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingMethods {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"John",21,true,"OsloMet"));
        studentList.add(new Student(2,"Ole",23,true,"OsloMet"));
        studentList.add(new Student(3,"Anna",22,true,"OsloMet"));
        studentList.forEach(s-> System.out.println(s));
        System.out.println("ordered list by certain properties:");

        Collections.sort(studentList, Comparator.comparing(Student::getName));
        studentList.forEach(s-> System.out.println(s));

        for(int i = 0; i<studentList.size();i++){
            System.out.println(studentList.get(i));
        }

        System.out.println();
    }
}
