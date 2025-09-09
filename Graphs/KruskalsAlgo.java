package Graphs;

import java.util.*;

public class KruskalsAlgo {

    static int n = 4; // number of vertices
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return find(par[x]);
        // return par[x]=find(par[x])  this is more optimized step because it reduces height as if there are many levels then
        // in recurion we go parent to parent ... here we made it so again if we do find ans comes easily
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parB]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    static class Edge implements Comparable<Edge> {

        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }

        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {
        // edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    public static int MST(ArrayList<Edge> edges, int V) { // O(lo)
        Collections.sort(edges);  // sort the edges first
        int mstCount = 0;
        int count = 0; // it the count of the edges and V is the number of vertices and count should be less than V-1 for a MST
        for (int i = 0; count < V - 1; i++) {
            Edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);
            if (parA != parB) {  //cycle checking condition
                union(e.src, e.dest);
                mstCount += e.wt;
            }
            count++;
        }
        return mstCount;
    }

    public static void main(String[] args) {
        int V = 4;
        init();
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        System.out.println(MST(edges, V));
    }
}
