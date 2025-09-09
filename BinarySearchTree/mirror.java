package BinarySearchTree;

public class mirror {

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

    public static Node CreateMirror(Node root) {
        if (root == null) {
            return null;
        }
        Node leftMirror = CreateMirror(root.left);
        Node rightMirror = CreateMirror(root.right);
        root.left = rightMirror;
        root.right = leftMirror;
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
        preorder(root);
        CreateMirror(root);
        System.out.println();
        preorder(root);
    }
}
