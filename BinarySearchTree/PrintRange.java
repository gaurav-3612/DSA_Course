package BinarySearchTree;

public class PrintRange {

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

    public static void InOrder(Node root) {
        if (root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

    public static void Print(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            Print(root.left, k1, k2);
            System.out.print(root.data + " "); // write print statement in thr middle becauuse inorder is sorted for bst
            Print(root.right, k1, k2);
        } else if (root.data <= k1) {
            Print(root.right, k1, k2); // here we do not write any print statement because after going to root.right then
            // root.right becomes root and it value becomes bigger because we have came towards right then root.data >= k1 && root.data <= k2 satifies
        } else {
            Print(root.left, k1, k2);
        }
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
        InOrder(root);
        System.out.println();
        Print(root, 2, 5);
    }
}

/*
 Print(5,1,4)
└── Print(1,1,4)
    ├── Print(null,1,4)
    ├── print 1
    └── Print(3,1,4)
        ├── Print(2,1,4)
        │   ├── Print(null,1,4)
        │   ├── print 2
        │   └── Print(null,1,4)
        ├── print 3
        └── Print(4,1,4)
            ├── Print(null,1,4)
            ├── print 4
            └── Print(null,1,4)


Print(5,5,7)
│
├── Print(1,5,7)
│   │
│   └── Print(3,5,7)
│       │
│       └── Print(4,5,7)
│           │
│           └── Print(null,5,7) // 4.right is null
│           └── returns to 4
│       └── returns to 3
│   └── returns to 1
│
├── Print prints 5
│
└── Print(7,5,7)
    │
    ├── Print(null,5,7) // 7.left is null
    │
    ├── Print prints 7
    │
    └── Print(null,5,7) // 7.right is null

 */
