package Graphs;

import java.util.ArrayList;

public class TarjansBridgeAlgo {

    static class Edge {

        int s;
        int d;

        public Edge(int s, int d) {
            this.s = s;
            this.d = d;
        }
    }

    public static void CreateGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int dt[], int low[], boolean visit[], int par, int time) {
        visit[curr] = true;
        dt[curr] = low[curr] = ++time;  // remember that it id ++time and not time++
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.d;
            if (neigh == par) {
                continue;
            } else if (!visit[neigh]) {
                dfs(graph, e.d, dt, low, visit, e.s, time);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (dt[curr] < low[neigh]) {
                    System.out.println(e.s + "----" + e.d);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    public static void tarjans(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];  // it is the time count
        int low[] = new int[V];  // it is lowest time count 
        int time = 0;
        boolean visit[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visit[i]) {
                dfs(graph, i, dt, low, visit, -1, time);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);
        tarjans(graph, V);
    }
}
