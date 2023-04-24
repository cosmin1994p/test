package genericsAndCollections;

public class IntegerPrinter {

    Integer thingToPrint;

    public IntegerPrinter(Integer print){
        this.thingToPrint = print;
    }

    public void print(){
        System.out.println(this.thingToPrint);
    }
}
