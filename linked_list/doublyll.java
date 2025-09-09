package linked_list;

public class doublyll {

    public static class Node {

        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    // addFirst
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode; // we must have to follow this order of assigning
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // removeLast
    public void removeFirst() {
        if (head == null) {
            System.out.println("already empty dll");
            return;
        }
        if (head.next == null) {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    // reversing a linked list
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;     // do not get confuse because we are not assigning curr value to prev for that we will do
            // curr.data,here the tail,head,prev,curr and next are node not variables
            curr = next;
        }
        head = prev;
    }

    // printing dll
    public void print() {
        if (head == null) {
            System.out.println("the dll is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        doublyll dll = new doublyll();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        dll.addFirst(5);
        dll.addFirst(100);
        dll.print();
        dll.removeFirst();
        dll.print();
        dll.reverse();
        dll.print();
    }
}
