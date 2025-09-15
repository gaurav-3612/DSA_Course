package linked_list;
// we can only make one public class

public class linkedList {

    // here we are making node class public so that we can re use it for linked list modification
    // but we can only make one public class so we made it static
    // we can also make Node class in non nested way i.e separate class
    public static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public static void main(String[] args) {
        linkedList l1 = new linkedList();
        l1.head = new Node(1);
        l1.head.next = new Node(2);
    }
}
/*public class linkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ✅ These should NOT be static
    public Node head;
    public Node tail;

    public static void main(String[] args) {
        linkedList l1 = new linkedList();
        linkedList l2 = new linkedList();

        l1.head = new Node(10);
        l2.head = new Node(20);

        System.out.println(l1.head.data); // 10
        System.out.println(l2.head.data); // 20
    }
}
 */

// -----------------------------------------------------------------------------------------------------------------------------
/*Problem With static Head & Tail

linkedList l1 = new linkedList();
linkedList l2 = new linkedList();

l1.head = new Node(10);
l2.head = new Node(20);
Even though you think l1 and l2 are separate lists, 
both are actually modifying the same static head, so the second assignment overwrites the first! */
