package Graphs;

import java.util.*;

public class CheapestFlights {

    static class Edge {

        int s, d, wt;

        public Edge(int s, int d, int wt) {
            this.s = s;
            this.d = d;
            this.wt = wt;
        }
    }

    public static void CreateGraph(ArrayList<Edge> graph[], int flights[][]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            int s = flights[i][0];
            int d = flights[i][1];
            int wt = flights[i][2];
            Edge e = new Edge(s, d, wt);
            graph[s].add(e);
        }
    }

    static class Info {

        int v, cost, stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int Cheapest(int flights[][], int n, int k, int src, int dst) {
        ArrayList<Edge> graph[] = new ArrayList[flights.length];
        CreateGraph(graph, flights);
        int dist[] = new int[n];
        for (int j = 0; j < dist.length; j++) {
            if (j != src) {
                dist[j] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.s;
                int v = e.d;
                int wt = e.wt;
                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt; // here we are not using dist[u] because see notes last slide of this question the ans comes wrong
                    // the reason is that we have to take the curr cost otherwise we take stops<k for a mid node get the ans also but atlast in counting stops>k
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }
        return dist[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;
        System.out.println(Cheapest(flights, n, k, src, dst));
    }
}
