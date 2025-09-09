package Graphs;

import Stacks.StacksByAl.stack;

import java.util.*;

public class TopologicalSorting {

    /*
    
     5 → 0
↓
2 → 3 → 1
↑    ↑
4 → 0   \
    ↓    \
    1     (no outgoing edges)

     */
    static class Edge {

        int s, d;

        public Edge(int s, int d) {
            this.s = s;
            this.d = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
    }

    public static void topoSort(ArrayList<Edge> graph[]) {
        boolean visit[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                topoUtil(graph, i, visit, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }

    public static void topoUtil(ArrayList<Edge> graph[], int curr, boolean visit[], Stack<Integer> s) {
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.d]) {
                topoUtil(graph, e.d, visit, s);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        System.out.println("Topological Sort:");
        topoSort(graph);
    }
}
/*
 Step-by-step DFS Dry Run
We call topoSort() → visit[] = all false → stack empty.

i = 0
visit[0] = true

No outgoing edges → push 0 → stack = [0]

i = 1
visit[1] = true

No outgoing edges → push 1 → stack = [0, 1]

i = 2
visit[2] = true

Neighbor: 3 (unvisited) → recurse

Inside curr = 3
visit[3] = true

Neighbor: 1 (visited already) → skip

Push 3 → stack = [0, 1, 3]

Back to curr = 2:

Push 2 → stack = [0, 1, 3, 2]

i = 3
Already visited → skip

i = 4
visit[4] = true

Neighbor: 0 (visited) → skip

Neighbor: 1 (visited) → skip

Push 4 → stack = [0, 1, 3, 2, 4]

i = 5
visit[5] = true

Neighbor: 0 (visited) → skip

Neighbor: 2 (visited) → skip

Push 5 → stack = [0, 1, 3, 2, 4, 5]
 */
