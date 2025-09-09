package BinarySearchTree;

public class largestSizeBSTFromBT {

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

        boolean isBST;
        int size;
        int max;
        int min;

        public Info(boolean isBST, int size, int max, int min) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxSize = 0;

    public static Info LargestBst(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Info leftInfo = LargestBst(root.left);
        Info RightInfo = LargestBst(root.right);
        // Info.size=leftInfo.size+RightInfo.size+1;  we cannot write like that because we had taken root as argument and not Info
        int size = leftInfo.size + RightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, RightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, RightInfo.max));
        if (root.data <= leftInfo.max || root.data >= RightInfo.min) {
            return new Info(false, size, max, min);
        }
        if (leftInfo.isBST && RightInfo.isBST) {
            maxSize = Math.max(maxSize, size);   // see this 
            return new Info(true, size, max, min);
        }
        return new Info(false, size, max, min);
    }

    public static void main(String[] args) {
        /*THIS IS A BINARY TREE

         20
       /    \
     10      30
    /  \    /  \
   5   25  15  35
  / \         / \
 1   8      32  40

         */

 /* THIS IS LARGEST SIZE BST
     10
    /  \
   5   25
  / \
 1   8   
         */
        Node root = new Node(20);

        // Creating and assigning left and right children of root
        root.left = new Node(10);
        root.right = new Node(30);

        // Left subtree
        root.left.left = new Node(5);
        root.left.right = new Node(25);

        root.left.left.left = new Node(1);
        root.left.left.right = new Node(8);

        // Right subtree
        root.right.left = new Node(15);
        root.right.right = new Node(35);

        root.right.right.left = new Node(32);
        root.right.right.right = new Node(40);
        Info info = LargestBst(root);
        System.out.println(maxSize);
    }
}
