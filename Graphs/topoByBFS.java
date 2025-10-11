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

/*
 🧠 Topological Sorting – Notes
🔹 Definition

Topological sorting of a Directed Acyclic Graph (DAG) is a linear ordering of its vertices such that for every directed edge u → v,
vertex u comes before vertex v in the ordering.

👉 Works only for Directed Acyclic Graphs (no cycles).
👉 Multiple valid orders may exist.

📍 Applications

Task scheduling with dependencies

Course prerequisite ordering

Build systems (compile order)

Resolving dependency graphs

🧩 Method 1: Kahn’s Algorithm (BFS / Indegree Method)
Basic Idea

Count how many edges are coming into each node → indegree.

A node with indegree 0 means nothing depends on it, so it can be done first.

Repeatedly remove such nodes and reduce the indegrees of their neighbors.

Steps

Compute indegree for each vertex.

Put all vertices with indegree = 0 into a queue.

While queue not empty:

Remove a vertex from queue and add it to topological order.

For each of its outgoing edges u → v, reduce indegree of v by 1.

If any vertex’s indegree becomes 0, add it to queue.

When done:

If all vertices are processed → valid topological order.

If not → graph has a cycle (topological sort not possible).

Dry Run Example

Graph edges:

5 → 2, 5 → 0, 4 → 0, 4 → 1, 2 → 3, 3 → 1

Node	Indegree
0	2 (from 5,4)
1	2 (from 3,4)
2	1 (from 5)
3	1 (from 2)
4	0
5	0

Start: Queue = [4, 5], Topo = []

Step 1: Remove 4
→ Add to topo: [4]
→ Decrease indegree of 0 and 1 → both become 1
Queue = [5]

Step 2: Remove 5
→ Add to topo: [4, 5]
→ Decrease indegree of 2 → 0 (add to queue)
→ Decrease indegree of 0 → 0 (add to queue)
Queue = [2, 0]

Step 3: Remove 2
→ Add to topo: [4, 5, 2]
→ Decrease indegree of 3 → 0 (add to queue)
Queue = [0, 3]

Step 4: Remove 0
→ Add to topo: [4, 5, 2, 0]
→ No outgoing edges
Queue = [3]

Step 5: Remove 3
→ Add to topo: [4, 5, 2, 0, 3]
→ Decrease indegree of 1 → 0 (add to queue)
Queue = [1]

Step 6: Remove 1
→ Add to topo: [4, 5, 2, 0, 3, 1]
Queue = []

✅ Final Topological Order: [4, 5, 2, 0, 3, 1]

Concept Summary

Uses indegrees and a queue.

Removes “independent” nodes first.

Detects cycles automatically if some nodes never reach indegree 0.

Time Complexity: O(V + E)

🧩 Method 2: DFS-Based Topological Sort
Basic Idea

Perform DFS traversal on the graph.

During DFS, after visiting all outgoing edges from a node, mark it finished.

Store each finished node (for example, push onto a stack).

After all DFS calls, reverse the finishing order → that’s the topological order.

👉 The trick: process nodes in reverse of their finishing time (postorder).

Steps

Mark all nodes as unvisited.

For each unvisited node, call DFS:

Mark node as visited.

Recursively visit all neighbors.

After all neighbors are done, record this node (finish time).

Reverse the recorded sequence → gives topological order.

Dry Run Example

Same graph:

5 → 2, 5 → 0, 4 → 0, 4 → 1, 2 → 3, 3 → 1


Start DFS in numerical order (0–5):

Node 0: no outgoing → finish(0)
→ Finish list: [0]

Node 1: no outgoing → finish(1)
→ Finish list: [0, 1]

Node 2: go to 3
→ DFS(3): go to 1 (already visited) → finish(3)
→ finish(2)
→ Finish list: [0, 1, 3, 2]

Node 3: already visited.

Node 4: go to 0 (visited), go to 1 (visited) → finish(4)
→ Finish list: [0, 1, 3, 2, 4]

Node 5: go to 2 (visited), go to 0 (visited) → finish(5)
→ Finish list: [0, 1, 3, 2, 4, 5]

✅ Reverse finishing order → Topological Order:

[5, 4, 2, 3, 1, 0]

Concept Summary

DFS explores deeper first → dependencies get finished before dependents.

When we reverse the finish order, every u → v has u before v.

Time Complexity: O(V + E)
 */
