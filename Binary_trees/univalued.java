package Binary_trees;

public class univalued {

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

    public static boolean univalued(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.data != root.left.data) {
            return false;
        }
        if (root.right != null && root.data != root.right.data) {
            return false;
        }
        boolean left = univalued(root.left);
        boolean right = univalued(root.right);
        if (left && right) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        /*
         1
       /   \
      1     1
     / \    /\
     1  1  1  1
         */
        Node root = new Node(1);
        root.left = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right = new Node(1);
        root.right.left = new Node(1);
        root.right.right = new Node(1);
        System.out.println(univalued(root));
    }
}
