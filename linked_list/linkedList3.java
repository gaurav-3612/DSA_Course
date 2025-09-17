package linked_list;

public class linkedList3 {

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

    //  add first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // find mid
    public Node FindMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // checking palindrome
    public boolean CheckPal() {
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = FindMid(head);
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public void print() {
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

    // merge sort on linked list
    public Node MidFinder(Node head) {
        Node slow = head;
        Node fast = head.next; // we need to have mid in left half hence we do this otherwise before we get the mid on
        // right half
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node MergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // finding mid
        Node mid = MidFinder(head);

        // making two halves
        Node left = head;
        Node right = mid.next; // it is necessary to store mid.next in right because after then we are making it null
        mid.next = null;

        left = MergeSort(left);
        right = MergeSort(right);
        return Merge(left, right);
    }

    // merge function
    public Node Merge(Node head1, Node head2) {
        Node mergedll = new Node(-1);
        Node temp = mergedll;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedll.next;
    }

    // zig zag linked list
    public void ZigZag() {
        // finding mid Node
        Node mid = MidFinder(head);
        // reversing the linked list
        Node curr = mid.next;
        Node prev = null;
        Node next;
        mid.next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev; // we have to link curr.next to prev not next.next to curr
            prev = curr;
            curr = next;
        }
        // altering ll elements
        Node lh = head;
        Node rh = prev;
        Node nextrh;
        Node nextlh;
        while (rh != null && lh != null) { //Using && ensures the loop stops when either list finishes,
            // preventing a NullPointerException on rh.next if rh becomes null
            nextlh = lh.next;
            nextrh = rh.next;
            lh.next = rh;
            rh.next = nextlh;
            rh = nextrh;
            lh = nextlh;
        }
    }

    public static void main(String[] args) {
        // for palinderome
        linkedList3 l1 = new linkedList3();
        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(3);
        l1.addFirst(4);
        l1.addFirst(5);
        l1.print();
        // System.out.println(l1.CheckPal());
        // head = l1.MergeSort(head);
        l1.ZigZag();
        l1.print();
    }
}

// deleting a node without knowing its head---->
// class Node
// {
//     int data ;
//     Node next;
//     Node(int d)
//     {
//         data = d;
//         next = null;
//     }
// }
// 
// class Solution {
//     public void deleteNode(Node del_node) {
//         del_node.data=del_node.next.data;
//         del_node.next=del_node.next.next;
//     }
// }
