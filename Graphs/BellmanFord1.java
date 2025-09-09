package Graphs;

import java.util.ArrayList;

/*
    (2)        (-2)
0 -----> 1 ----------> 4
 \       ^             |
  \     (-1)           | (2)
   (4)   |             v
    ---> 2 ----------> 3 
                (2)  

 */
public class BellmanFord1 {

    static class Edge {

        int s, d, wt;

        public Edge(int s, int d, int wt) {
            this.s = s;
            this.d = d;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {
        // Example graph
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, -2));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(3, 4, 4));
    }

    public static void bellman(ArrayList<Edge> edges, int V, int src) {
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for (int j = 0; j < V - 1; j++) { // loop for updating v-1 times
            for (int k = 0; k < edges.size(); k++) { // for edges
                Edge e = edges.get(k);
                int u = e.s;
                int v = e.d;
                int wt = e.wt;
                // relaxtation
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt; // use wt dont do dist[wt]
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        int V = 5;
        createGraph(edges);
        // You can pass 'edges' into Bellman-Ford function
        bellman(edges, V, 0);
    }
}
