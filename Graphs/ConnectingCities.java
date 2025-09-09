package Graphs;

import java.util.*;

public class ConnectingCities {

    static class Edge implements Comparable<Edge> {

        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }
    }

    public static int connect(int cities[][]) {
        boolean visit[] = new boolean[cities.length];
        int dist[] = new int[cities[0].length];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        int finalCost = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (!visit[curr.dest]) {
                visit[curr.dest] = true;
                finalCost += curr.dest;
                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0) {
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalCost;
    }

    public static void main(String[] args) {// final time complexity is O(V² log V)
        int cities[][] = {{0, 1, 2, 3, 4}, // it is cities[u][v] means from u to v weight is given and 0 means no edge
        {1, 0, 5, 0, 7},
        {2, 5, 0, 6, 0},
        {3, 0, 6, 0, 0},
        {4, 7, 0, 0, 0}};
        System.out.println(connect(cities));
    }
}
/*
 while(!pq.isEmpty()) {
    Edge curr = pq.remove();
    if(!vis[curr.dest]) {
        vis[curr.dest] = true;
        finalCost += curr.cost;

        for(int i = 0; i < cities[curr.dest].length; i++) {
            if(cities[curr.dest][i] != 0) {
                pq.add(new Edge(i, cities[curr.dest][i]));
            }
        }
    }
}

Now line-by-line:

while(!pq.isEmpty()) {

Repeat the block while the priority queue (pq) has at least one Edge in it.

pq is a PriorityQueue<Edge> where Edge objects are ordered by cost (lowest cost first).

The loop ends when there are no candidate edges left to consider.

Edge curr = pq.remove();

Remove and return the head (the smallest-cost element) of the priority queue and store it in curr.

remove() will throw an exception if the queue is empty, but we checked !pq.isEmpty() so this is safe. (An alternative is pq.poll() which returns null if empty.)

curr is an Edge object with two fields used here: curr.dest (the vertex this edge goes to) and curr.cost (the weight).

if(!vis[curr.dest]) {

vis[] is a boolean array tracking whether a vertex has already been added to the MST (visited).

This if checks whether the destination vertex curr.dest has not been visited yet.

Why this check? Because the PQ can contain multiple edges pointing to the same vertex (from different neighbors). Only the first time we pop an edge that reaches an unvisited vertex do we accept it into the MST. If the vertex is already visited, this edge would create a cycle and should be ignored.

vis[curr.dest] = true;

Mark this vertex as visited (added to the MST).

After this assignment, future edges popped that have dest == curr.dest will be ignored by the if check.

finalCost += curr.cost;

Add the cost of this accepted edge to the running total MST cost (finalCost).

This is where we accumulate the total weight of the minimum spanning tree being built.

for(int i = 0; i < cities[curr.dest].length; i++) {

Iterate over all possible neighbor indices i for the vertex curr.dest.

cities is the adjacency matrix: cities[u][v] is the weight of the edge from u to v, or 0 if no edge. cities[curr.dest].length is typically the number of vertices.

if(cities[curr.dest][i] != 0) {

Check if there is an edge from curr.dest to vertex i. Your code uses 0 to indicate “no edge” (so any non-zero is a real edge).

Important subtlety: this code assumes there are no legitimate zero-weight edges except the diagonal (self edges). If you had edges of weight 0 in the graph, this test would incorrectly treat them as nonexistent.

pq.add(new Edge(i, cities[curr.dest][i]));

Create a new Edge object representing an edge from some visited vertex (curr.dest) to neighbor i with cost cities[curr.dest][i], and add that edge to the priority queue.

We do not check vis[i] before adding. That means edges to already visited vertices are still added; later when they are popped they will be skipped by the if(!vis[...) check.

The PQ keeps these candidate edges sorted by cost so the next remove() gives the smallest-cost candidate edge.

} (end of if(cities...)

Close the neighbor-existence check.

} (end of for loop)

After adding all neighbor edges of curr.dest to the PQ, we exit the neighbor loop.

} (end of if(!vis...))

If curr.dest had already been visited, none of the lines 4–10 run — we simply skip to the next iteration and remove the next best edge from the PQ.

} (end of while)

Loop repeats: remove the next cheapest edge from the PQ, accept it if it reaches a new vertex, add its neighbors, etc., until the PQ empties.
 */
