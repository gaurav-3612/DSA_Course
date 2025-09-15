package backtracking;

public class grid {

    public static int gridways(int i, int j, int n, int m) {
        // base
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }
        // kaam
        int w1 = gridways(i + 1, j, n, m);
        int w2 = gridways(i, j + 1, n, m);
        return w1 + w2;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        System.out.println(gridways(0, 0, n, m));
    }
}
/*
 gridways(0,0)
├── gridways(1,0)
│   ├── gridways(2,0)
│   │   ├── gridways(3,0) = 0   (out of bounds)
│   │   └── gridways(2,1)
│   │       ├── gridways(3,1) = 0   (out of bounds)
│   │       └── gridways(2,2) = 1   (destination)
│   │       => 1
│   │   => 1
│   └── gridways(1,1)
│       ├── gridways(2,1)
│       │   ├── gridways(3,1) = 0
│       │   └── gridways(2,2) = 1
│       │   => 1
│       └── gridways(1,2)
│           ├── gridways(2,2) = 1
│           └── gridways(1,3) = 0
│           => 1
│       => 2
│   => 3
└── gridways(0,1)
    ├── gridways(1,1)
    │   ├── gridways(2,1)
    │   │   ├── gridways(3,1) = 0
    │   │   └── gridways(2,2) = 1
    │   │   => 1
    │   └── gridways(1,2)
    │       ├── gridways(2,2) = 1
    │       └── gridways(1,3) = 0
    │       => 1
    │   => 2
    └── gridways(0,2)
        ├── gridways(1,2)
        │   ├── gridways(2,2) = 1
        │   └── gridways(1,3) = 0
        │   => 1
        └── gridways(0,3) = 0   (out of bounds)
        => 1
    => 3
=> 6

 */
