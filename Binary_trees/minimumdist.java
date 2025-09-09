package Binary_trees;

public class minimumdist {

    static class Node {

        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node lca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftlca = lca(root.left, n1, n2);
        Node rightlca = lca(root.right, n1, n2);

        if (leftlca == null) {
            return rightlca;
        } else if (rightlca == null) {
            return leftlca;
        } else {
            return root;
        }
    }

    public static int MinDist(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);
        int minleft = FindDist(lca, n1);
        int minright = FindDist(lca, n2);
        return minleft + minright;
    }

    public static int FindDist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int left = FindDist(root.left, n);
        int right = FindDist(root.right, n);

        if (left == -1 && right == -1) {
            return -1;
        } else if (left == -1) {
            return right + 1;
        } else {
            return left + 1;
        }
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
        System.out.print(MinDist(root, 4, 7));
    }
}
