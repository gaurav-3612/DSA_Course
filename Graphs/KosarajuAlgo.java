package Graphs;

import java.util.*;

public class KosarajuAlgo {

    static class Edge {

        int s;
        int d;

        public Edge(int s, int d) {
            this.s = s;
            this.d = d;

        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void dfs(ArrayList<Edge> graph[], boolean visit[], int curr) {
        System.out.print(curr + " ");
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.d]) {  // we are not writing e.s beacue e.s is same for all graph[curr] as all have same source
                dfs(graph, visit, e.d);
            }
        }
    }

    public static void topoSort(ArrayList<Edge> graph[], boolean visit[], int curr, Stack<Integer> s) {
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.d]) {  // we are not writing e.s beacue e.s is same for all graph[curr] as all have same source
                topoSort(graph, visit, e.d, s);
            }
        }
        s.push(curr);
    }

    public static void transpose(ArrayList<Edge> graph[], ArrayList<Edge> transpose[], boolean visit[]) {
        for (int i = 0; i < transpose.length; i++) {
            transpose[i] = new ArrayList<>();
            visit[i] = false;  // there is nor reason of this, in this it just to write in make visit again falae to true
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);   // change src position to dest and dest position to src
                transpose[e.d].add(new Edge(e.d, e.s));
            }
        }
    }

    public static void kosaRaju(ArrayList<Edge> graph[], int curr) {
        boolean visit[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        topoSort(graph, visit, curr, s);
        ArrayList<Edge> transpose[] = new ArrayList[graph.length];
        transpose(graph, transpose, visit);
        while (!s.isEmpty()) {
            int now = s.pop();
            if (!visit[now]) {
                System.out.print("SCC : ");
                dfs(transpose, visit, now);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosaRaju(graph, 0);
    }
}
