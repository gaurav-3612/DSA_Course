package Graphs;

import java.util.*;

public class PrimsGraph {

    static class Edge {

        int s, d, wt;

        public Edge(int s, int d, int wt) {
            this.s = s;
            this.d = d;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected edges
        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 2, 3));

        graph[1].add(new Edge(1, 0, 4));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 2));

        graph[2].add(new Edge(2, 0, 3));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 4));
        graph[2].add(new Edge(2, 4, 5));

        graph[3].add(new Edge(3, 1, 2));
        graph[3].add(new Edge(3, 2, 4));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 2, 5));
        graph[4].add(new Edge(4, 3, 1));

        // the main reason we use visited is graph[x] is 14 but actual edges are just 7 so we dont want to visit edges twice
    }

    static class Pair implements Comparable<Pair> {

        int v;  // node
        int c;  // cost 

        public Pair(int v, int c) {
            this.v = v;
            this.c = c;
        }

        public int compareTo(Pair p2) {
            return this.c - p2.c;
        }
    }

    public static int Cost(ArrayList<Edge> graph[]) {
        boolean visit[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0)); // this is not the info of first node it is just the start with(0,0)
        int finalCost = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visit[curr.v]) {
                visit[curr.v] = true;
                finalCost += curr.c;
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.d, e.wt));
                }
            }
        }
        return finalCost;
    }

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[5];
        createGraph(graph);
        System.out.println(Cost(graph));
    }
}
/*
 Edges (undirected):

0 ↔ 1 (4)

0 ↔ 2 (3)

1 ↔ 2 (1)

1 ↔ 3 (2)

2 ↔ 3 (4)

2 ↔ 4 (5)

3 ↔ 4 (1)

Step 2: Dry Run of Prim’s Algorithm
We start with:


visit = [false, false, false, false, false]
pq = [(0,0)]
finalCost = 0
Iteration 1
Pop (0,0) → visit[0] = true

Add cost: finalCost = 0 + 0 = 0

Push neighbors:

(1,4)

(2,3)


pq = [(2,3), (1,4)]
visit = [true, false, false, false, false]
finalCost = 0
Iteration 2
Pop (2,3) → visit[2] = true

Add cost: finalCost = 0 + 3 = 3

Push neighbors:

(0,3) // visited, but still goes to pq

(1,1)

(3,4)

(4,5)


pq = [(1,1), (1,4), (3,4), (0,3), (4,5)]
visit = [true, false, true, false, false]
finalCost = 3
Iteration 3
Pop (1,1) → visit[1] = true

Add cost: finalCost = 3 + 1 = 4

Push neighbors:

(0,4) // visited

(2,1) // visited

(3,2)


pq = [(3,2), (1,4), (3,4), (0,3), (4,5), (0,4), (2,1)]
visit = [true, true, true, false, false]
finalCost = 4
Iteration 4
Pop (3,2) → visit[3] = true

Add cost: finalCost = 4 + 2 = 6

Push neighbors:

(1,2) // visited

(2,4) // visited

(4,1)


pq = [(4,1), (1,4), (3,4), (0,3), (4,5), (0,4), (2,1), (1,2), (2,4)]
visit = [true, true, true, true, false]
finalCost = 6
Iteration 5
Pop (4,1) → visit[4] = true

Add cost: finalCost = 6 + 1 = 7

Push neighbors:

(2,5) // visited

(3,1) // visited

pq = [... only visited nodes remain ...]
visit = [true, true, true, true, true]
finalCost = 7
Iterations 6+
All popped nodes are already visited → skip.

✅ Final MST cost = 7

 */
