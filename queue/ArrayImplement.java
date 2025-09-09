package queue;

public class ArrayImplement {

    public static class Queue {

        public int size;
        public int arr[];
        public int rear;
        public int front; // rear and front store indexes

        public Queue(int n) {
            size = n;
            arr = new int[n];
            rear = -1;
            front = 0;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public void add(int data) {
            if (rear == (size - 1)) {
                System.out.println("queue is already full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("no element before");
                return -1;
            }
            int val = arr[front];
            for (int i = 0; i < rear; i++) { // we do not include rear because one element is removed, i point to i+1 i.e. null
                arr[i] = arr[i + 1];
            }
            rear = rear - 1;
            return val;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("no element before");
                return -1;
            }
            int val = arr[front];
            return val;
        }
    }

    public static void main(String[] args) {
        Queue q1 = new Queue(3); // n must be defined because queue has consteructor having int n as arg.
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
