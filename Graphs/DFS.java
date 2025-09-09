package Graphs;

import java.util.*;


/* 
        1-----3
       /     | \
      0      |  5---6
       \     | /
        2-----4
 */
public class DFS {

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
        graph[0].add(new Edge(0, 2, 1));
        // 1 vertex
        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 0, 1));
        // 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[3].add(new Edge(3, 4, 1));
        // 5 vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        // 6 vertex
        graph[6].add(new Edge(6, 5, 1));
        // 4 vertex
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        // 2 vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
    }

    public static void DFSAlgo(ArrayList<Edge> graph[], int curr, boolean visit[]) {   // o(v+e) and if we use adjency matrix then it will be o(v2)
        // boolean visit[] = new boolean[graph.length];  we cannot define it here because it id done by recursion and every call new visit will get created means no stoppage of recursion
        System.out.print(curr + " ");
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.d]) {
                DFSAlgo(graph, e.d, visit);
            }
        }
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        CreateGraph(graph);
        DFSAlgo(graph, 0, new boolean[v]);
    }
}
