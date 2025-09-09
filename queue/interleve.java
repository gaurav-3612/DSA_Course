package queue;

import java.util.*;

public class interleve {

    public static void QueueInterleve(Queue<Integer> q) {
        int size = q.size();  // it is necessary to use size variable instead of queue.size() as queue size is variable
        Queue<Integer> FirstQueue = new ArrayDeque<>();
        for (int i = 0; i < (size / 2); i++) {
            FirstQueue.add(q.remove());
        }
        while (!FirstQueue.isEmpty()) {
            q.add(FirstQueue.remove());
            q.add(q.remove());
        }
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        QueueInterleve(q);
    }
}
