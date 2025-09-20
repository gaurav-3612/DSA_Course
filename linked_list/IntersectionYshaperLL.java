package linked_list;

class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class IntersectionYshaperLL {

    public Node intersectPoint(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Node p1 = headA;
        Node p2 = headB;
        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }
        return p1;
    }
}
