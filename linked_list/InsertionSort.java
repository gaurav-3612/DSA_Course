package linked_list;

public class InsertionSort {

    // Definition for singly-linked list
    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val <= curr.next.val) {
                curr = curr.next;
            } else {
                ListNode toInsert = curr.next;
                curr.next = toInsert.next;

                ListNode prev = dummy;
                while (prev.next.val < toInsert.val) {
                    prev = prev.next;
                }

                toInsert.next = prev.next;
                prev.next = toInsert;
            }
        }
        return dummy.next;
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        InsertionSort solution = new InsertionSort();

        // Create linked list: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));

        System.out.print("Original: ");
        printList(head);

        head = solution.insertionSortList(head);

        System.out.print("Sorted: ");
        printList(head);
    }
}
/*
 Approach:

Use a dummy (sentinel) node before the head → simplifies insertions at the front.

Maintain curr = last node in sorted part.

If curr.val <= curr.next.val, list is in order → move curr.

Else:

Detach toInsert = curr.next.

Find position from dummy (prev) where prev.next.val >= toInsert.val.

Insert:

toInsert.next = prev.next;
prev.next = toInsert;


Don’t move curr (since curr.next changed).

Return dummy.next as new head.
 */
