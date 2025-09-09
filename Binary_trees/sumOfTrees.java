package Binary_trees;

public class sumOfTrees {

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

    public static int transform(Node root) {
        if (root == null) {
            return 0;
        }
        int leftChild = transform(root.left); // this is the different value i.e it is the return value not actual means it is not root.left.data
        int rightChild = transform(root.right);
        int prevleft = leftChild == 0 ? 0 : root.left.data;
        int prevright = rightChild == 0 ? 0 : root.right.data;

        int data = root.data;
        root.data = leftChild + rightChild + prevleft + prevright;
        return data;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {

        /*
         1
       /   \
      2     3
     / \    /\
     4  5  6  7
         */

 /*
         27
       /   \
      9     13
     / \    /\
     0  0  0  0
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        transform(root);
        preOrder(root);
    }
}
