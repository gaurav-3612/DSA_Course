package Graphs;

import java.util.*;


/* 
        1-----3
       /     | \
      0      |  5---6
       \     | /
        2-----4
 */
public class HasPath {

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

    public static boolean CheckPath(ArrayList<Edge> graph[], int src, int dest, boolean visit[]) {
        if (src == dest) {
            return true;
        }
        visit[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visit[e.d] && CheckPath(graph, e.d, dest, visit)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        CreateGraph(graph);
        System.out.println(CheckPath(graph, 0, 5, new boolean[v]));
        System.out.println(CheckPath(graph, 0, 10, new boolean[v]));
    }
}

/*
 CheckPath(0, 100)   // started at 0
 └── CheckPath(1, 100)   // from 0 → 1
      └── CheckPath(3, 100)   // from 1 → 3
           └── CheckPath(5, 100)   // from 3 → 5
                └── CheckPath(4, 100)   // from 5 → 4
                     └── CheckPath(2, 100)   // from 4 → 2
When CheckPath(2, 100) finishes:

It has no unvisited neighbors.

It executes return false;

That false is sent back up to the function that called it → CheckPath(4, 100).

Now inside CheckPath(4, 100):
The loop was at neighbor 2 when it called CheckPath(2, 100).

That call came back with false.

So the loop in node 4 continues to the next neighbor (if any).

If there are no more neighbors, CheckPath(4, 100) also returns false to its caller → CheckPath(5, 100).
 */
