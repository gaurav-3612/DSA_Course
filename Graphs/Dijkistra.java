package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
     (2)
0 ---------> 1
|            |\
|            | \(3)
|(4)         |  \
|            v   v
2 ---------> 3 → 4
     (1)     (5)

 */
public class Dijkistra {

    static class Edge {
        // here destination (d) and distance dist[i] are two different things dont confuse

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

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 4, 5));
    }

    static class Pair implements Comparable<Pair> {

        int n; // node
        int path; // dist to this node from src

        public Pair(int n, int path) {   // (node,distance of this node from src)
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) { // sort the pairs on the basis of path 
            return this.path - p2.path;
        }
    }

    public static void dijkstraAlgo(ArrayList<Edge> graph[], int src) {
        boolean visit[] = new boolean[graph.length]; // to track pairs visited or not means node can be visited more than once here but pair should be visited once only
        int dist[] = new int[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visit[curr.n]) {      // we are thinking that we visit a node more that one time for updating to minimum so why used this visit=true
                visit[curr.n] = true;  // yes the node enters in queue with different path value but lowest one came first and make changes according to that this makes visit true and nothing happens when more path become pop
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.s;  // node from where e comes as source
                    int v = e.d;   // destination
                    int wt = e.wt;  // distance of destination from src
                    if (dist[u] + wt < dist[v]) {   // see we are not doing anything with u and v we are dealing with dist[u] & dist[v]
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }

        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        dijkstraAlgo(graph, 0);
    }
}
/*
        (2)         (7)
  0 --------> 1 --------> 3
   \          |           |
   (4)       (1)          (1)
    \         v           v
     \----->  2 --------> 5
             (3)         ^
              \          |
               v         (5)
               4 ---------
               (2)

 graph[0] = (0→1, 2), (0→2, 4)
graph[1] = (1→3, 7), (1→2, 1)
graph[2] = (2→4, 3)
graph[3] = (3→5, 1)
graph[4] = (4→3, 2), (4→5, 5)
graph[5] = (none)


dist[]  = [0, ∞, ∞, ∞, ∞, ∞]   // src = 0
visit[] = [F, F, F, F, F, F]
pq      = [(0,0)]


Pop (0,0)
visit[0] = true

Edges:

0→1 (wt 2): dist[1] = 0 + 2 = 2 → push (1,2)

0→2 (wt 4): dist[2] = 0 + 4 = 4 → push (2,4)

similarly:

dist = [0, 2, 3, 9, ∞, ∞]
pq   = [(2,3), (2,4), (3,9)]

dist = [0, 2, 3, 9, 6, ∞]
pq   = [(4,6), (3,9), (2,4)]

dist = [0, 2, 3, 8, 6, 9]
pq   = [(5,9), (5,11), (3,9), (2,4)]

dist = [0, 2, 3, 8, 6, 9]
pq   = [(3,9), (5,11), (2,4)]

0 → 0 : 0
0 → 1 : 2
0 → 2 : 3
0 → 3 : 8
0 → 4 : 6
0 → 5 : 9

 */
