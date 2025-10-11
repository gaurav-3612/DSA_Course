package Graphs;

import java.util.ArrayList;

public class CycleDirected {

    /*
    Example directed graph with a cycle:
        0 → 1 → 2
             ↑   |
             |   ↓
             4 ← 3
     */
    static class Edge {

        int s, d;

        public Edge(int s, int d) {
            this.s = s;
            this.d = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Edges
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 1)); // back edge creating cycle: 1 → 2 → 3 → 4 → 1
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean visit[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length]; // its name is stack but actually it is an array to keep the record of the actual recurdion stack of recursive calls
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                if (detectCycleUtil(graph, i, visit, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], int curr, boolean visit[], boolean stack[]) {
        visit[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.d]) {
                return true;
            } else if (!stack[e.d] && detectCycleUtil(graph, e.d, visit, stack)) {
                return true;
            }
        }
        stack[curr] = false;  // “I am done exploring this node, so it’s no longer part of my current DFS path.”
        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println(detectCycle(graph)); // Expected: true
    }
}
/*

 Why visited[] alone is not enough
If you only used visited[], then when you revisit a node that was visited in a different DFS path, you might wrongly assume it’s a cycle — even if it’s not.

Example without recStack[]:
    0 → 1 → 2
        ↑   /
        |  /
        3

What recStack[] does:
recStack[] keeps track of nodes that are still being explored in the current DFS branch.
Case 1: You reach a node that’s visited but not in recStack → This was visited in a different path; no cycle here.
Case 2: You reach a node that’s visited and in recStack → This node is part of the current DFS path → Back edge → cycle.

 */

 /*
  | Step | Current Node | Action                                                           | visited\[]  | recStack\[] | Cycle Found? |
| ---- | ------------ | ---------------------------------------------------------------- | ----------- | ----------- | ------------ |
| 1    | 0            | visit                                                            | {T,F,F,F,F} | {T,F,F,F,F} | No           |
| 2    | 1 (from 0)   | visit                                                            | {T,T,F,F,F} | {T,T,F,F,F} | No           |
| 3    | 2 (from 1)   | visit                                                            | {T,T,T,F,F} | {T,T,T,F,F} | No           |
| 4    | 3 (from 2)   | visit                                                            | {T,T,T,T,F} | {T,T,T,T,F} | No           |
| 5    | 1 (from 3)   | already visited **and** recStack\[1] = true → **cycle detected** | same        | same        | ✅ Yes        |

 */

 /*
  🔹 Step Table (Cycle Example)

For this cyclic graph:

0 → 1 → 2 → 3 → 4 → 1

Step	Current Node	visited[]	recStack[]	Observation
1	0	{T,F,F,F,F}	{T,F,F,F,F}	Start from 0
2	1	{T,T,F,F,F}	{T,T,F,F,F}	Go to 1
3	2	{T,T,T,F,F}	{T,T,T,F,F}	Go to 2
4	3	{T,T,T,T,F}	{T,T,T,T,F}	Go to 3
5	4	{T,T,T,T,T}	{T,T,T,T,T}	Go to 4
6	Edge 4→1	Already in recStack	→ Cycle found ✅	

Output: true

🔹 Example 2 (No Cycle)
0 → 1 → 2
     ↑
     3

Graph representation
Node	Outgoing edges
0	1
1	2
2	—
3	1
Dry Run

Initial:

visited = {F,F,F,F}
recStack = {F,F,F,F}


DFS flow:

Step	Current Node	Action	visited[]	recStack[]	Cycle?
1	0	visit 0	{T,F,F,F}	{T,F,F,F}	No
2	1 (from 0)	visit 1	{T,T,F,F}	{T,T,F,F}	No
3	2 (from 1)	visit 2	{T,T,T,F}	{T,T,T,F}	No
4	2 → no edges	backtrack	{T,T,T,F}	{T,T,F,F}	No
5	Back to 1 → backtrack	{T,T,T,F}	{T,F,F,F}	No	
6	Back to 0 → backtrack	{T,T,T,F}	{F,F,F,F}	No	
7	Start from 3	visit 3	{T,T,T,T}	{F,F,F,T}	No
8	3 → 1	already visited, not in recStack	skip	same	No

✅ No cycle found

Output: false

🔹 Summary
Concept	Meaning
Cycle	Path that leads back to the same node
visited[]	Marks all visited nodes
recStack[]	Tracks current DFS path
Condition for cycle	If we find an edge to a node with recStack[destination] == true
Correction	Use !visit[e.d] instead of !stack[e.d]
  */
