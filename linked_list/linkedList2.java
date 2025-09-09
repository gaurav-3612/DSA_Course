package linked_list;

public class linkedList2 {

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

    /*
         ❌ Use static only if you want a single shared list across all instances (rarely needed).

         ✅ Use non-static head and tail if you want to build an actual object-oriented linked list, 
             where each object is independent.

          So, in real-world coding and OOP design, head and tail should not be static.
     */
    public void addFirst(int data) {  //o(n)
        // step1--create a new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step2-newNode next=head
        newNode.next = head;

        // step 3- head=newNode
        head = newNode;
    }

    public void addLast(int data) { //o(n)
        // step1--create a new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step2-newNode next=head
        tail.next = newNode;

        // step 3- head=newNode
        tail = newNode;
        // the next of newnode automatically points to null, we do not need to define it
    }

    // add in the middle
    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < (idx - 1)) { // if we want to insert at idx=2 then while loop happens olny
            //  two time for 0 and 1 and temp points to 2nd
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        /* 
            Suppose your list is:

            [10] → [20] → [30]
                    ↑
                   temp
             And you're inserting newNode = [25] after temp.

             newNode.next = temp.next;  // 25 → 30
             temp.next = newNode;       // 20 → 25
             Now the list becomes:

             [10] → [20] → [25] → [30] 
         */
    }

    // remove first
    public int removeFirst() {
        if (size == 0) {
            System.out.println("already empty linked list");
            return 0;
        }
        if (size == 1) {
            int val = head.data; // if we directly write int val=head it is wrong as head is Node 
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // remove last
    public int removeLast() {
        if (size == 0) {
            System.out.println("already empty linked list");
            return 0;
        }
        if (size == 1) {
            int val = head.data; // if we directly write int val=head it is wrong as head is Node 
            head = tail = null;
            size = 0;
            return val;
        }
        int val = tail.data;
        // we need to find prev which is at size-2(if talking about index it is idx-1) if idx starts from 0
        int idx = 0;
        Node prev = head;
        while (idx < (size - 2)) {
            prev = prev.next;
            idx++;
        }
        prev.next = null;
        tail = prev; // do not write prev=tail, because then there will be two tails
        size--;
        return val;
    }

    public int removeBetween(int idx) {
        int i = 0;
        Node prev = head;
        while (i < (idx - 1)) {
            prev = prev.next;
            i++;
        }
        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    // search in the linked list without recursion
    public int search1(int key) {
        Node point = head;
        if (point.data == key) {
            return 0;
        }
        for (int i = 0; i < size; i++) {
            point = point.next;
            if (point.data == key) {
                return (i + 1);
            }
        }
        return -1;
    }

    // search in the linked list with recursion
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) { // we have made new ll every time by removing previous head and making new head
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1; // this is written because if we find no key then get -1 from above head==null,if it is not written
            //  then (idx+1) occurs which is wrong 
        }
        return (idx + 1);
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    // reversing a linked list
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;     // do not get confuse because we are not assigning curr value to prev for that we will do
            // curr.data,here the tail,head,prev,curr and next are node not variables
            curr = next;
        }
        head = prev;
    }

    // printing a linked list
    public void print() {
        if (head == null) {
            System.out.println("linked list");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        linkedList2 l1 = new linkedList2();
        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(3);
        l1.addLast(4);
        l1.addLast(5);
        l1.addLast(6);
        l1.add(2, 100);
        l1.removeFirst();
        l1.removeLast();
        l1.removeBetween(2);
        l1.print();
        System.out.println(l1.size);
        System.out.println(l1.search1(100));
        System.out.println(l1.recSearch(4));
        l1.reverse();
        l1.print();
    }
}
