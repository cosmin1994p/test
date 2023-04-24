package demo.dataStructures;

import java.util.*;

public class StandardDS {
    public static void main(String[] args) {
        System.out.println("Live-koding - datastrukturer");

        // deklarering og initialisering
        int array[] = {1,34,5,42,54,23,8,66,99,87};

        List<Integer> enkelListe = new ArrayList<>();
        List<Integer> enkelListe2 = new ArrayList<>(Arrays.asList(1, 34));
        List<Integer> sammenkjedetListe = new LinkedList<>();
        List<Integer> stakk = new Stack<>();

        // insert
        enkelListe.add(array[0]);
        sammenkjedetListe.add(array[0]);
        stakk.add(array[0]);

        // print
        System.out.println(enkelListe.toString());
        System.out.println(enkelListe2.toString());
        System.out.println(sammenkjedetListe.toString());
        System.out.println(stakk.toString());

        // find
        System.out.println(enkelListe.get(0));
        System.out.println(sammenkjedetListe.get(0));
        System.out.println(stakk.get(0));

        // slett
        enkelListe.remove(0);
        sammenkjedetListe.remove(0);
        stakk.remove(0);

        // størrelse/lengde
        System.out.println(enkelListe.size());
        System.out.println(sammenkjedetListe.size());
        System.out.println(stakk.size());

        // funksjoner for stakk
        Stack<Integer> stakk2 = (Stack<Integer>) stakk;
        stakk2.push(1);
        stakk2.push(2);
        stakk2.push(3);
        System.out.println(stakk2.size());
        System.out.println(stakk2.pop());
        System.out.println(stakk2.size());
    }
}
