package Graphs;

import java.util.ArrayList;

/* 
        1-----3
       /     | \
      0      |  5---6
       \     | /
        2-----4
 */
public class CycleLength {

    static class Edge {

        int s;
        int d;
        int wt;

        public Edge(int s, int d, int wt) {
            this.s = s;
            this.d = d;
            this.wt = wt;
        }
    }

    public static void CreateGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0 vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        // 1 vertex
        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 0, 1));
        // 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[3].add(new Edge(3, 4, 1));
        // 5 vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        // 6 vertex
        graph[6].add(new Edge(6, 5, 1));
        // 4 vertex
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        // 2 vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean visit[] = new boolean[graph.length];
        ArrayList<Integer> path = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                if (detectCycleUtil(graph, i, -1, visit, path)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static int cycleLength = 0;

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], int curr, int par, boolean visit[], ArrayList<Integer> path) {
        visit[curr] = true;
        path.add(curr);

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!visit[e.d]) {
                if (detectCycleUtil(graph, e.d, curr, visit, path)) {
                    return true;
                }
            } else if (visit[e.d] && e.d != par) {
                // Found a cycle → calculate length
                int idx = path.indexOf(e.d);
                if (idx != -1) {
                    cycleLength = path.size() - idx;
                }
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        CreateGraph(graph);
        System.out.println(detectCycle(graph));
        System.out.println(cycleLength);
    }
}
/*
 Dry run table (cycle length detection)
We track:

path = DFS stack from root to current

visit[] = visited nodes

cycleLength = computed when back-edge found

Step-by-step
Start:

ini
Copy
Edit
visit = [false, false, false, false, false, false, false]
path = []
cycleLength = 0
1. detectCycle() starts at i = 0

visit[0] = true, path = [0]

Neighbor 1 → not visited → DFS(1, parent=0)

2. At node 1

visit[1] = true, path = [0, 1]

Neighbor 0 visited, is parent → ignore

Neighbor 3 → not visited → DFS(3, parent=1)

3. At node 3

visit[3] = true, path = [0, 1, 3]

Neighbor 1 visited, is parent → ignore

Neighbor 4 → not visited → DFS(4, parent=3)

4. At node 4

visit[4] = true, path = [0, 1, 3, 4]

Neighbor 3 visited, is parent → ignore

Neighbor 5 → not visited → DFS(5, parent=4)

5. At node 5

visit[5] = true, path = [0, 1, 3, 4, 5]

Neighbor 3 visited, not parent (parent is 4) → cycle found

path = [0, 1, 3, 4, 5]

indexOf(3) in path = 2

path.size() - idx = 5 - 2 = 3

cycleLength = 3

At this moment:


Cycle length = 3 nodes
Cycle path segment = [3, 4, 5]
DFS returns true all the way up.

Result
detectCycle() returns true

cycleLength = 3

Printed output could be:

true
Cycle length: 3
 */
