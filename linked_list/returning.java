package linked_list;

import java.util.LinkedList;

public class returning {

    public static LinkedList<Integer> createLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Head: " + list.getFirst()); // 10
        System.out.println("Tail: " + list.getLast());  // 30
        return list;  // returning the LinkedList
    }

    public static void main(String[] args) {
        LinkedList<Integer> result = createLinkedList();
        System.out.println(result); // Output: [10, 20, 30]

    }
}
