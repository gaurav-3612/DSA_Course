package Binary_trees;

public class OptimizedDiameter {

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

        int dia;
        int ht;

        public Info(int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static Info Diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftD = Diameter(root.left);  // here we tried to calculte the diameter but height also get calculated as method is same
        Info rightD = Diameter(root.right);
        int dia = Math.max(Math.max(leftD.dia, rightD.dia), leftD.ht + rightD.ht + 1);  //here we used ht berfore calculted with it calculated automatically
        int ht = Math.max(leftD.ht, rightD.ht) + 1;
        return new Info(dia, ht); // we write new Info here not in return null because null is already defined in java
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
        System.out.println(Diameter(root).dia);
        System.out.println(Diameter(root).ht);

    }
}
