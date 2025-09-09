package Graphs;

import java.util.ArrayList;

public class SourceToTarget {

    /*
    Example directed graph with a cycle:
        0 → 1 → 2
             ↑   |
             |   ↓
             4 ← 3
     */
    static class Edge {

        int s, d;

        public Edge(int s, int d) {
            this.s = s;
            this.d = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Edges
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 1)); // back edge creating cycle: 1 → 2 → 3 → 4 → 1
    }

    public static void path(ArrayList<Edge> graph[], int src, int dest, String path, boolean visit[]) { // o(v^v), doing with DFS
        if (src == dest) {
            System.out.println(path + dest);
        }
        visit[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visit[e.d]) {
                path(graph, e.d, dest, path + src + " ", visit);
            }
        }
        visit[src] = false; // f we never set visited[src] back to false after exploring all its neighbors, that node will stay “blocked” for future paths — even when it would be valid to revisit it through a completely different route.
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean visit[] = new boolean[v]; //When we’re exploring all paths between two nodes, we use a visited[] array to avoid revisiting nodes within the same path (to prevent cycles).
        path(graph, 3, 2, "", visit);
    }
}
