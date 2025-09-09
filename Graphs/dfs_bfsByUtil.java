package Graphs;

import java.util.*;

public class dfs_bfsByUtil {

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
    // NORMAL BFS AND DFS :
//     2️⃣ Does this work for isolated points?
// Case 1 — Graph is connected
// ✅ Works fine — BFS will visit all vertices connected to the source.

// Case 2 — Graph has isolated nodes or multiple disconnected components
// ❌ This code will NOT visit isolated nodes if they are not connected to the starting vertex.
// Why?
// BFS starts from a single source (here 0) and only explores vertices reachable from that source.
// If a vertex has no path from the source, BFS never even touches it.
// So if vertex 4 is isolated, BFS starting at 0 will never print 4.
// BFS
    public static void bfs(ArrayList<Edge> graph[]) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                bfs_util(graph, visit, i);
            }
        }
    }

    public static void bfs_util(ArrayList<Edge> graph[], boolean visit[], int start) {   // o(v+e) and if we use adjency matrix then it will be o(v2)
        Queue<Integer> q = new LinkedList<>();
        q.add(start);   // we also called start from bfs because if we hard code it by adding 0 then when we go to the unconnected graph then all start again from 0
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visit[curr]) { // this true means earlier false beacuse of ! that means earlier it was not visited
                System.out.print(curr + " ");
                visit[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.d);
                }
            }
        }
    }

    // DFS
    public static void dfs(ArrayList<Edge> graph[]) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dfs_util(graph, i, visit);
        }
    }

    public static void dfs_util(ArrayList<Edge> graph[], int curr, boolean visit[]) {   // o(v+e) and if we use adjency matrix then it will be o(v2)
        System.out.print(curr + " ");
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.d]) {
                dfs_util(graph, e.d, visit);
            }
        }
    }

}
