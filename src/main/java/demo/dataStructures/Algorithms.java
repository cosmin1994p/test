package demo.dataStructures;

public class Algorithms {
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }
    public static int factorial(int nr){
        if (nr==0){
            return 1;
        }else{
            return (nr * factorial(nr-1));
        }
    }
}
