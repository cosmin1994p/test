package genericsAndCollections;

public class StringPrinter {
               /// a lot of code duplicationss
    String thingToPrint;

    public StringPrinter(String print){
        this.thingToPrint = print;
    }

    public void print(){
        System.out.println(this.thingToPrint);
    }
}
