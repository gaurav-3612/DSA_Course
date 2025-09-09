package BinarySearchTree;

import java.util.*;

public class BSTtobalancedBST {

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

    public static Node balancedBST(Node root) {
        ArrayList<Integer> l = new ArrayList<>();
        Inorder(root, l);
        Node ans = CreateBst(l, 0, l.size() - 1);
        return ans;
    }

    public static void Inorder(Node root, ArrayList<Integer> l) {
        if (root == null) {
            return;
        }
        Inorder(root.left, l);
        l.add(root.data);
        Inorder(root.right, l);
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

    public static void main(String[] args) {
        /*   THIS IS BST
          5                              
         / \                          
        4   6                         
       /     \                      
      3       7                        
     /         \                            
    2           8                       
   /            \                         
   1             9                       

         */


 /*   THIS IS BALANCED BST
       5
     /   \
    2     7
   / \   / \
  1   3 6   8
       \       \
        4      9

         */
        Node root = new Node(5);

        // Left skewed side
        root.left = new Node(4);
        root.left.left = new Node(3);
        root.left.left.left = new Node(2);
        root.left.left.left.left = new Node(1);

        // Right skewed side
        root.right = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.right.right.right = new Node(9);
        preorder(root);
        System.out.println();
        preorder(balancedBST(root));
    }
}
