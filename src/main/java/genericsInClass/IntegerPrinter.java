package genericsInClass;

public class IntegerPrinter {
    Integer thingToPrint;

    public IntegerPrinter(Integer thing){
        thingToPrint = thing;
    }

    public void printThing(){
        System.out.println(thingToPrint);
    }
}
