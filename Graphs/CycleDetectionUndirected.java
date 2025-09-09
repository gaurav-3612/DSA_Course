package Graphs;

import java.util.ArrayList;

/* 
        1-----3
       /     | \
      0      |  5---6
       \     | /
        2-----4
 */
public class CycleDetectionUndirected {

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
        // graph[0].add(new Edge(0, 2, 1));

        // 1 vertex
        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 0, 1));

        // 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 5, 1));
        // graph[3].add(new Edge(3, 4, 1));

        // 5 vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 vertex
        graph[6].add(new Edge(6, 5, 1));
        // 4 vertex
        // graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[4].add(new Edge(4, 2, 1));

        // 2 vertex
        // graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                if (detectCycleUtil(graph, i, -1, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], int curr, int par, boolean visit[]) {
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // case 3
            if (!visit[e.d]) { // for not visited neigbour, we simply do visit
                if (detectCycleUtil(graph, e.d, curr, visit)) {
                    return true;
                }
            } // case 1 
            else if (visit[e.d] && e.d != par) { // for visited neighbour, we check if it is parent node or any other node
                return true;
            }
            // case 3
            // simply goes forward
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        CreateGraph(graph);
        System.out.println(detectCycle(graph));
    }
}
/*
  Dry run (DFS) — step-by-step

We call detectCycle() which iterates i = 0..6. The first unvisited vertex is 0, so we start DFS from node 0.

Legend: visit[] marks when a node becomes visited. par is the parent passed in recursion.

i = 0 → call detectCycleUtil(graph, 0, -1, visit)

mark visit[0] = true

neighbors of 0: [1, 2]

take neighbor 1 (unvisited) → recurse

detectCycleUtil(graph, 1, 0, visit)

mark visit[1] = true

neighbors of 1: [0, 3]

neighbor 0 is visited and equals parent par=0 → ignore

neighbor 3 unvisited → recurse

detectCycleUtil(graph, 3, 1, visit)

mark visit[3] = true

neighbors of 3: [1, 4, 5]

neighbor 1 visited and equals parent par=1 → ignore

neighbor 4 unvisited → recurse

detectCycleUtil(graph, 4, 3, visit)

mark visit[4] = true

neighbors of 4: [3, 5, 2]

neighbor 3 visited and equals parent par=3 → ignore

neighbor 5 unvisited → recurse

detectCycleUtil(graph, 5, 4, visit)

mark visit[5] = true

neighbors of 5: [3, 4, 6]

neighbor 3 is visited and 3 != par (4) → cycle detected

At this point the function returns true and the true value propagates up the recursion chain.

Detected back-edge: 5 -> 3 (3 was already visited earlier on the recursion stack). The cycle is 3 -> 4 -> 5 -> 3.
 */
