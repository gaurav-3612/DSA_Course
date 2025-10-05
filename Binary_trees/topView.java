package Binary_trees;

import java.util.*;

public class topView {

    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {

        Node node;
        int horizDist;

        public Info(int hd, Node node) {
            this.horizDist = hd;  // because of this now if we call Info.hd then it is wrong we need Info.horizDist
            this.node = node;
        }
    }

    public static void topView(Node root) {
        Queue<Info> q = new LinkedList<>(); // this is used to traverse in bfs manner
        // ❌ With ArrayDeque: Throws NullPointerException immediately when adding null
        HashMap<Integer, Node> h = new HashMap<>();
        int min = 0, max = 0;
        q.add(new Info(0, root)); // we have to use the new keyword because it is not earlier defined
        q.add(null);
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!h.containsKey(curr.horizDist)) { // to check only unique nodes come in map not twice
                    h.put(curr.horizDist, curr.node); // by this we are putting elements in hashmap but only unique ones
                }
                if (curr.node.left != null) {
                    q.add(new Info(curr.horizDist - 1, curr.node.left));
                    min = Math.min(curr.horizDist - 1, min);
                }
                if (curr.node.right != null) {
                    q.add(new Info(curr.horizDist + 1, curr.node.right));
                    max = Math.max(curr.horizDist + 1, max);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(h.get(i).data + " ");
        }
    }

    public static void main(String[] args) {
        /*
         1
       /   \
      2     3
     / \    /\
     4  5  6  7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        topView(root);
    }
}
