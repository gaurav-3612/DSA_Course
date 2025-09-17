package linked_list;
// a < b > c < d > e ...

class ZigZagLinkedList {

    public static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node zigZag(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        boolean less = true; // first relation should be <
        Node curr = head;

        while (curr != null && curr.next != null) {
            if ((less && curr.data > curr.next.data)
                    || (!less && curr.data < curr.next.data)) {
                swap(curr, curr.next);
            }
            less = !less;  // flip expectation
            curr = curr.next;
        }

        return head;
    }

    private void swap(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
}
/*
  4 → 3 → 7 → 8 → 6 → 2 → 1

  Iteration 1

Pair = (4, 3), less = true → expect 4 < 3.

Condition: (4 > 3) → true → swap.

List becomes:

3 → 4 → 7 → 8 → 6 → 2 → 1


Flip less = false.

Iteration 2

Pair = (4, 7), less = false → expect 4 > 7.

Condition: (4 < 7) → true → swap.

List becomes:

3 → 7 → 4 → 8 → 6 → 2 → 1


Flip less = true.

✅ After continuing, final output will be:

3 → 7 → 4 → 8 → 2 → 6 → 1


Which satisfies:

3 < 7 > 4 < 8 > 2 < 6 > 1
 */
