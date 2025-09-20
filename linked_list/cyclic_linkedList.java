package linked_list;

public class cyclic_linkedList {

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
    public static int size;

    // checking cycle
    public static boolean Cycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            /*
             If you use || instead:
The loop would continue if either fast != null or fast.next != null is true.
For example, if fast is null, but fast.next != null is checked, it throws a NullPointerException 
because you are trying to access .next of null
             */
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // removing cycle
    public static void RemoveCycle() {
        // detecting cycle
        Node slow = head;
        Node fast = head;
        int flag = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                flag = 1;
                break;
            }
        }
        if (slow == head) {
            while (fast.next != slow) { // move fast until it’s the last node in cycle
                fast = fast.next;
            }
            fast.next = null; // break loop by making last node point to null
            return;
        }
        // putting slow to head and again starting by +1 by both fast and slow
        if (flag == 1) {
            slow = head;
            Node prev = null;
            while (fast != slow) {
                prev = fast; // it is necessary to write it here to remain previous of head
                slow = slow.next;
                fast = fast.next;
            }
            prev.next = null;
        }
    }

    public static void print() {
        Node prev = head;
        if (head == null) {
            System.out.print("empty string");
        }
        while (prev != null) {
            System.out.print(prev.data + "->");
            prev = prev.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

// here we cannot make object of cyclic_linkedList class and no error comes because or head and Node class is static
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;

// we cannot call non static methods in static main method without creating object so we made cyclic method static
        RemoveCycle();
        print();
    }
}
