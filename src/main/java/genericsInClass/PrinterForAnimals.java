package genericsInClass;

public class PrinterForAnimals<T extends Animal> {       //   T = String
    public T thingToPrint;     // String

    public PrinterForAnimals(T thing){   //String
        thingToPrint = thing;
    }

    public void print(){
        System.out.println(thingToPrint);
    }
}
