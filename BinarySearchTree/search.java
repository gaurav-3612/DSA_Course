package BinarySearchTree;

public class search {

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

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        } else if (key > root.data) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }
    }

    public static void main(String args[]) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = build(root, values[i]);
        }
        System.out.println(search(root, 2));
    }
}
