package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Example {

    public static Queue<String> createQueue() {
        Queue<String> queue = new LinkedList<>();
        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");
        System.out.println("Front: " + queue.peek()); // 1

        LinkedList<String> temp = (LinkedList<String>) queue; //You should cast the queue to a LinkedList of String,
        //  not Integer, since your queue contains String elements.
        System.out.println("Rear: " + temp.getLast());
        return queue;  // returning the Queue
    }

    public static void main(String[] args) {
        Queue<String> result = createQueue();
        System.out.println(result); // Output: [Alice, Bob, Charlie]
    }
}
