package BinarySearchTree;

public class isValidBST {

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

    public static boolean Validity(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }
        return Validity(root.left, min, root) && Validity(root.right, root, max);
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
        System.out.println(Validity(root, null, null));
    }
}

/*
 Call 1: Validity(5, null, null)
    ✔️ 5 is valid (no min/max violation)
    
    ├── Call 2: Validity(1, null, 5)
    │       ✔️ 1 < 5 → valid
        
    │       ├── Call 3: Validity(null, null, 1)
    │       │       ✔️ null → returns true
        
    │       └── Call 4: Validity(3, 1, 5)
    │               ✔️ 3 > 1 && 3 < 5 → valid
            
    │               ├── Call 5: Validity(2, 1, 3)
    │               │       ✔️ 2 > 1 && 2 < 3 → valid
                    
    │               │       ├── Call 6: Validity(null, 1, 2)
    │               │       │       ✔️ null → returns true
                    
    │               │       └── Call 7: Validity(null, 2, 3)
    │               │               ✔️ null → returns true
                    
    │               │       🔙 returns true (both left & right true)
                
    │               └── Call 8: Validity(4, 3, 5)
    │                       ✔️ 4 > 3 && 4 < 5 → valid
                        
    │                       ├── Call 9: Validity(null, 3, 4)
    │                       │       ✔️ null → returns true
                        
    │                       └── Call 10: Validity(null, 4, 5)
    │                               ✔️ null → returns true
                        
    │                       🔙 returns true (both left & right true)
            
    │               🔙 returns true (both left & right true)
        
    │       🔙 returns true (both left & right true)
    
    └── Call 11: Validity(7, 5, null)
            ✔️ 7 > 5 → valid
        
            ├── Call 12: Validity(null, 5, 7)
            │       ✔️ null → returns true
        
            └── Call 13: Validity(null, 7, null)
                    ✔️ null → returns true
        
            🔙 returns true (both left & right true)
    
🔙 Final return: true (tree is valid BST)

 */
