package queue;

import java.util.*;
import java.util.LinkedList;

public class queueJCF {

    public static void main(String[] args) {
        // queue is interface in jcf so we cannot make objects of it
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        q1.add(100);
        q1.add(1);
        q1.add(2);
        q1.remove();
        q1.add(3);
        while (!q1.isEmpty()) {
            System.out.println(q1.peek());
            q1.remove();
        }
    }
}
