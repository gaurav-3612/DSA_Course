package Graphs;

import java.util.*;

/* 
        1-----3
       /     | \
      0      |  5---6
       \     | /
        2-----4
 */
public class bipartite {

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

    public static boolean CheckBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length]; // instead of boolean, color -1,0 or 1 will help to determine whether the node is travesed or not
        for (int i = 0; i < graph.length; i++) {
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) { // this loop is for unconnected graphs because e.d covers only the connected edges
            if (color[i] == -1) { // not colred yet
                q.add(i);
                color[i] = 0; // say yellow color
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {  // for calculating the neighbours of curr
                        Edge e = graph[curr].get(j);
                        if (color[e.d] == -1) { // not colored yet
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.d] = nextColor;
                            q.add(e.d);
                        } else if (color[e.d] == color[curr]) {
                            return false;
                        }
                        // for next case in which the node is colore and not same to curr goes forward no changes need to done
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        CreateGraph(graph);
        System.out.println(CheckBipartite(graph));
    }
}
