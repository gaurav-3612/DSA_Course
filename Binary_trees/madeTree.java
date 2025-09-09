package Binary_trees;

public class madeTree {

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

    static class BinaryTree {

        static int idx = -1; // to use it in BuildTree function we have to make it static variable

        public static Node BuildTree(int nodes[]) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {  //(nodes[idx] == -1 || idx == nodes.length) is wrong for array out of index
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);
            return newNode;
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 3, -1, -1, 5, 6, 7, -1, -1, 5, 2, 5, 6, 7, -1};
        BinaryTree b1 = new BinaryTree();
        Node root = b1.BuildTree(nodes);
        System.out.println(root.data);
    }
}
