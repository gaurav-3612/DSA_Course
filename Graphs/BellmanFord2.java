package Graphs;

import java.util.ArrayList;

public class BellmanFord2 {

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

        // Edges
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -2));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
    }

    public static void bellman(ArrayList<Edge> graph[], int V, int src) {
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for (int j = 0; j < V - 1; j++) { // loop for updating v-1 times
            for (int l = 0; l < graph.length; l++) {
                for (int k = 0; k < graph[l].size(); k++) { // for edges
                    Edge e = graph[l].get(k);
                    int u = e.s;
                    int v = e.d;
                    int wt = e.wt;
                    // relaxtation
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt; // use wt dont do dist[wt]
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // You can pass 'edges' into Bellman-Ford function
        bellman(graph, V, 0);
    }

}
