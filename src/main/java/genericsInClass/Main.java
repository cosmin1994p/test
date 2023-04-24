package genericsInClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        IntegerPrinter printer = new IntegerPrinter(10);
        printer.printThing();

        StringPrinter printer1 = new StringPrinter("sdgohffiosjghfkl");
        printer1.printThing();

        // Generic approach
        Printer<String> genericPrinter = new Printer<String>("fsklghflgdgdf");
        genericPrinter.print();

        Printer<Integer> genericPrinterInteger = new Printer<Integer>(1111);
        genericPrinterInteger.print();

        Printer<Double> genericPrinterDouble = new Printer<Double>(1111.22);
        genericPrinterDouble.print();

        PrinterForAnimals<Cat> printerForAnimals = new PrinterForAnimals(new Cat());

        shout("Generic are complicated ");
        shout(234235);
        shout(true);
        shout(new Cat());

        List<Integer> arr1 = new ArrayList();
        arr1.add(42535);
        arr1.add(25);
        arr1.add(5445);
        arr1.add(4234);

        int a = 0;
        //Why do we need type safety
        for(Object o: arr1){
            System.out.println(o);
            a = a + (Integer)o;
        }
        System.out.println(a);

        // Sets
        //- all the elements inside this "list" have to be unique
        //- the order of the elements is not sorted
        System.out.println("-----SETS --------");
        Set<String> simpleSet = new HashSet();
        simpleSet.add("Oslo");
        simpleSet.add("Bucharest");
        simpleSet.add("Rome");
        simpleSet.add("Rome");
        simpleSet.add("Rome");
        simpleSet.add("Rome");
        simpleSet.add("Rome");

        for(String st: simpleSet){
            System.out.println(st);
        }



    }
    //Generic method
    public static <Q> void shout(Q value){    //T = String
        System.out.println(value + "!!!!!!");
    }
}
