package Binary_trees;

public class subtree {

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

    public static boolean isSubtree(Node root, Node subroot) {
        // the main aim of Subtree function is that we call identical when we find root.data==subroot.data rest isidentical will do
        if (root == null) {
            return false;
        }
        if (root.data == subroot.data) {
            if (isIdentical(root, subroot)) { // this is true stops going below
                return true;
            }
        }
        return (isSubtree(root.left, subroot) || isSubtree(root.right, subroot));
    }

    public static boolean isIdentical(Node root, Node subroot) {
        // here we try to detect false return cases and return true in else cases
        if (root == null && subroot == null) {
            return true;
        } else if (root == null || subroot == null || root.data != subroot.data) {

            // root.data != subroot.data || root == null || subroot == null is wrong because 
            // compliler reads line by line from lrft to right, and if subroot.left or .right 
            // is nothing then subroot.left ot right will give null point exception error
            return false;
        }
        // if (!isIdentical(root.left, subroot.left)) { // we can also directly call isIdentical recursively but here we are dealing
        //     return false;                       // the all false cases and return true atlast so if we do not wrute this conditon
        // }                                       //then we always get true as at last return is true this return false going below
        // if (!isIdentical(root.right, subroot.right)) {
        //     return false;
        // }
        // return true;
        return (isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right));
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

        //   2
        //  / \
        //  4  5
        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);
        System.out.println(isSubtree(root, subroot));
    }
}
