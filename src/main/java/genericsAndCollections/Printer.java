package genericsAndCollections;

public class Printer <T extends Animal> {
    T thingToPrint;

    public Printer(T thing){
        this.thingToPrint = thing;
    }

    public void print(){
        System.out.println(this.thingToPrint);
    }
}
