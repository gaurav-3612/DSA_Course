package BinarySearchTree;

import java.util.Arrays;

public class balancedBST {

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

    public static Node balanced(int arr[], int st, int ed) {
        if (st > ed) {
            return null;
        }
        int mid = (st + ed) / 2;
        Node root = new Node(arr[mid]);
        root.left = balanced(arr, st, mid - 1);// don't include the mid beacuse mid becomes root now
        root.right = balanced(arr, mid + 1, ed);
        return root;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 1, 9, 10};
        Arrays.sort(arr);// array must be sorted for a bst
        preorder(balanced(arr, 0, arr.length - 1));
    }
}
/*
 ✅ Balanced BST definition
A Balanced Binary Search Tree is a BST where the height difference between left and right subtrees is minimal (usually ≤1). In a BST:

All nodes in the left subtree are smaller than the root.

All nodes in the right subtree are greater than the root.
 */
