package Graphs;

import java.util.*;

public class topoByBFS {

    /*
5 → 0
↓
2 → 3 → 1
↑    ↑
4 → 0     \
    ↓      \
    1        (no outgoing edges)

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

    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i; // used just to show that that i is vertices here nothing as much
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indeg[e.d]++;
            }
        }
    }

    public static void topoSort(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int ele = q.remove();
            System.out.print(ele + " ");
            for (int i = 0; i < graph[ele].size(); i++) {
                Edge e = graph[ele].get(i);
                indeg[e.d]--;
                if (indeg[e.d] == 0) {  // we added again in queue because there is no recusrion in it so that it automatically gets in the queue, now we done in the while loop
                    q.add(e.d);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        System.out.println("Topological Sort:");
        topoSort(graph);
    }
}
