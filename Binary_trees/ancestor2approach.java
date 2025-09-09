package Binary_trees;

public class ancestor2approach {

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

    public static Node Ancestor(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftlca = Ancestor(root.left, n1, n2);
        Node rightlca = Ancestor(root.right, n1, n2);

        if (leftlca != null && rightlca != null) {
            return root;
        }
        if (leftlca == null) {
            return rightlca;
        }
        if (rightlca == null) {
            return leftlca;
        }
        return root; // this line will never run because one of the case must be true above i can also use else above 
    }

    public static void main(String[] args) {

        /*
         1
       /   \
      2     3
     / \    /\
     4  5  6  7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(Ancestor(root, 4, 5).data);
    }
}
