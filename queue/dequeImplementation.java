package queue;

import java.util.Deque;
import java.util.LinkedList;

public class dequeImplementation {

    public static void main(String[] args) {
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(1);
        d.addLast(2);
        d.addFirst(3);
        d.removeFirst();
        d.removeLast();
        int p = d.getFirst();
        int q = d.getLast();
        System.out.println(p + "," + q);
        System.out.println(d);
    }
}
