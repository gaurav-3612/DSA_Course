package linked_list;

import java.util.*;

// You’re given a multilevel doubly linked list:
// Each node has:
// val → value
// prev → pointer to previous node.
// next → pointer to next node.
// child → pointer to another doubly linked list (this could also have its own children).
// So it’s like a normal doubly linked list, but some nodes can have children lists hanging down from them.
// 👉 The task: Flatten this list so it becomes a single-level doubly linked list, where all child lists are merged into the main list in order.
class FlattenLinkedLL {

    class Node {

        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        Node dummy = new Node();
        dummy.next = head;
        head.prev = dummy;

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        Node prev = dummy;

        while (!stack.isEmpty()) {
            Node curr = stack.pop();

            // Connect prev and curr
            prev.next = curr;
            curr.prev = prev;

            // Push next node first (because stack is LIFO)
            if (curr.next != null) {
                stack.push(curr.next);
            }

            // Push child node next (so it gets processed first)
            if (curr.child != null) {
                stack.push(curr.child);
                curr.child = null; // important! remove child link
            }

            prev = curr;
        }

        // Detach dummy node
        dummy.next.prev = null;
        return dummy.next;
    }
}

/*
 
📌 Approach I Used (Iterative with Stack)

We want to traverse like Depth-First Search (DFS):

Start from the head.

If a node has a child:

Insert the child list immediately after the current node.

Continue down the child list before going back to next.

If there’s no child, just move to the next.

Keep doing this until all nodes are processed.

 */
