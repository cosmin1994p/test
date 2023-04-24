package genericsInClass;

public class Printer <T> {       //   T = String
    public T thingToPrint;     // String

    public Printer(T thing){   //String
        thingToPrint = thing;
    }

    public void print(){
        System.out.println(thingToPrint);
    }
}
