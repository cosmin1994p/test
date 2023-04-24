package demo.dataStructures;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> linkVisited = new Stack<>();
        linkVisited.add("Google");
        linkVisited.add("Wiki");
        linkVisited.add("Java");
        linkVisited.add("Jakarta");
        linkVisited.peek();
        System.out.println(linkVisited.peek());

        linkVisited.pop();
        linkVisited.pop();
        linkVisited.pop();
        linkVisited.pop();
        linkVisited.pop();

    }
}
