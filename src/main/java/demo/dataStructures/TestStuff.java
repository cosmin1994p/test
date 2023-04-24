package demo.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestStuff {

    public static void main(String[] args) {

//        long startTime = System.nanoTime();
//        List<String> arr = new ArrayList<>();
//        for(int i=0; i<10000000;i++){
//            arr.add("akfljflkjsdsldfngflgnsfgsjfngslkdfjgnsl;kfjgnsf;glkjsnfg");
//        }
//        long endTime   = System.nanoTime();
//        long totalTime = endTime - startTime;
//        System.out.println(totalTime);
//        List<String> arr = new ArrayList<>();
//        for(int i=0; i<10000000;i++){
//            arr.add("akfljflkjsdsldfngflgnsfgsjfngslkdfjgnsl;kfjgnsf;glkjsnfg");
//        }
//        List<String> arr2 = new LinkedList<>();
//        for(int i=0; i<10000000;i++){
//            arr2.add("akfljflkjsdsldfngflgnsfgsjfngslkdfjgnsl;kfjgnsf;glkjsnfg");
//        }

        saySomething();
    }
    public static void saySomething(){
        System.out.println("Say something");
        saySomething();
    }
}


