package Graphs;

import java.util.*;

public class garph_creation {

    static class Edge {

        int s;
        int d;  // destination is actually a neighbour
        int wt;

        public Edge(int s, int d, int wt) {
            this.s = s;
            this.d = d;
            this.wt = wt;
        }
    }

    /*    (5)
           0-----1
                 --
          (1)    -  - (3)
               -    -
              2 ---- 3
              -  (1)
              -
              -  (2)
              4
     */
    public static void main(String[] args) {
        int v = 5;
        // int arr[]=new int[n];
        ArrayList<Edge> graph[] = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0 th vertex
        graph[0].add(new Edge(0, 1, 5));
        // q vertex
        graph[1].add(new Edge(1, 3, 3));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 0, 5));
        //2 vertex;
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 3));
        graph[2].add(new Edge(2, 4, 1));

        for (int i = 0; i < graph[2].size(); i++) { // printing neighbour  of vertex 2 in the graph
            Edge e = graph[2].get(i);
            System.out.println(e.d);
        }

    }
}
