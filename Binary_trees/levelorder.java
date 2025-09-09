package Binary_trees;

import java.util.*;

public class levelorder {

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

    static class BinaryTree {

        static int idx = -1; // to use it in BuildTree function we have to make it static variable

        public static Node BuildTree(int nodes[]) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {  //(nodes[idx] == -1 || idx == nodes.length) is wrong for array out of index
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);
            return newNode;
        }

        public static void LevelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>(); // we made queue of data type Node and not of Integer
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        System.out.println();
                        q.add(null);
                    }
                } else {
                    System.out.print(curr.data);
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7};
        BinaryTree b1 = new BinaryTree();
        Node root = b1.BuildTree(nodes);
        b1.LevelOrder(root);
    }
}
