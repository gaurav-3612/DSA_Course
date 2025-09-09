package BinarySearchTree;

import java.util.ArrayList;

public class mergeBSTs {

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

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node CreateBst(ArrayList<Integer> l, int st, int ed) {
        if (st > ed) {
            return null;
        }
        int mid = (st + ed) / 2;
        Node root = new Node(l.get(mid));
        root.left = CreateBst(l, st, mid - 1);
        root.right = CreateBst(l, mid + 1, ed);
        return root;
    }

    public static void getInOrder(Node root, ArrayList<Integer> a) {
        if (root == null) {
            return;
        }
        getInOrder(root.left, a);
        a.add(root.data);
        getInOrder(root.right, a);
    }

    public static Node merge(Node root1, Node root2) {
        // get in order for bst1
        ArrayList<Integer> a1 = new ArrayList<>();
        getInOrder(root1, a1);

        // get in order for bst1
        ArrayList<Integer> a2 = new ArrayList<>();
        getInOrder(root2, a2);
        // merging the two arraylists
        ArrayList<Integer> f = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a1.size() && j < a2.size()) {
            if (a1.get(i) < a2.get(j)) {
                f.add(a1.get(i));
                i++;
            } else {
                f.add(a2.get(j));
                j++;
            }
        }
        while (i < a1.size()) {
            f.add(a1.get(i));
            i++;
        }
        while (j < a2.size()) {
            f.add(a2.get(j));
            j++;
        }
        return CreateBst(f, 0, f.size() - 1);
    }

    public static void main(String[] args) {
        /*          

         5                       8
        / \                     / \
       3   7                   4   10

         */

 /*
             5
          /     \
         3       8
          \     /  \
           4   7    10

         */
        // THIS IS BST 1
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        // THIS IS BST2
        Node root2 = new Node(8);
        root2.left = new Node(4);
        root2.right = new Node(10);
        preorder(merge(root1, root2));
    }
}
