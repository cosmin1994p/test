package genericsInClass;

public class StringPrinter {
    String thingToPrint;

    public StringPrinter(String thing){
        thingToPrint = thing;
    }

    public void printThing(){
        System.out.println(thingToPrint);
    }
}
