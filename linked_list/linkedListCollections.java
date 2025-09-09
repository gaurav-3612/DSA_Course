package linked_list;

import java.util.LinkedList;

public class linkedListCollections {

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.addFirst(2);
        l1.addFirst(4);
        l1.addLast(7);
        l1.addLast(9);
        l1.addFirst(1);
        l1.removeFirst();
        l1.removeLast();
        System.out.println(l1);
    }
}
