package BinarySearchTree;

import java.util.*;

public class rootToLeaf {

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

    public static Node build(Node root, int value) {
        if (root == null) {
            root = new Node(value); // use root=new Node(value) and not Node root=new Node(root)
            return root;
        }
        if (value < root.data) {
            root.left = build(root.left, value);
        }
        if (value > root.data) {
            root.right = build(root.right, value);
        }
        return root;
    }

    public static void RootToLeaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            PrintPath(path);
        }
        RootToLeaf(root.left, path);
        RootToLeaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void PrintPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("null");
    }

    /*
    
        5
      /   \
     1     7
      \
       3
      / \
     2   4

     */
    public static void main(String args[]) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = build(root, values[i]);

        }
        RootToLeaf(root, new ArrayList<>());
    }
}
