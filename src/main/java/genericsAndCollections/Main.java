package genericsAndCollections;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        IntegerPrinter integerPrinter = new IntegerPrinter(12345);
        integerPrinter.print();

        StringPrinter stringPrinter = new StringPrinter("this is a random string");
        stringPrinter.print();

//        Printer<Integer> printer = new Printer<>(12);
//        printer.print();


        //Type safety solved with generics

        ArrayList<Object> list = new ArrayList();
        list.add(new Cat());

        Cat cat = (Cat)list.get(0);
        shout("shout","1");

    }

    //generic methods
    public static <T, V>  T  shout (T thingToShout, V anotherThing) {
        V another;
        System.out.println( thingToShout + "!!");
        return thingToShout;
    }
}
