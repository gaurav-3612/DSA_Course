package queue;

public class LinkedList {

    public class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public class Queue {

        public int size;
        public Node head;
        public Node tail;

        Queue() {
            this.size = 0;
            this.head = null;
            this.tail = null;
        }

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            size++;
            if (isEmpty()) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("already empty");
                return -1;
            }
            int val = head.data;
            if (size == 1) {
                head = tail = null;
                size--;
                return val;
            }
            head = head.next;
            size--;
            return val;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("already empty");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        Queue q1 = l.new Queue();        // if the class is not static then we need to do this
        q1.add(100);
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.remove();
        while (!q1.isEmpty()) {
            System.out.println(q1.peek());
            q1.remove();
        }
    }
}
