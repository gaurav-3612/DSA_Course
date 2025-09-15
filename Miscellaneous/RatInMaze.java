package Miscellaneous;
// gfg

import java.util.*;

public class RatInMaze {

    // Function to find all paths
    public static ArrayList<String> findPath(int[][] mat, int n) {
        ArrayList<String> result = new ArrayList<>();

        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return result; // no path possible
        }

        boolean[][] visited = new boolean[n][n];
        backtrack(mat, n, 0, 0, "", visited, result);

        Collections.sort(result); // ensure lexicographic order
        return result;
    }

    // Helper backtracking function
    private static void backtrack(int[][] mat, int n, int x, int y, String path, boolean[][] visited, ArrayList<String> result) {
        // If destination reached
        if (x == n - 1 && y == n - 1) {
            result.add(path);
            return;
        }

        // Mark as visited
        visited[x][y] = true;

        // Move Down
        if (isSafe(mat, n, x + 1, y, visited)) {
            backtrack(mat, n, x + 1, y, path + "D", visited, result);
        }

        // Move Left
        if (isSafe(mat, n, x, y - 1, visited)) {
            backtrack(mat, n, x, y - 1, path + "L", visited, result);
        }

        // Move Right
        if (isSafe(mat, n, x, y + 1, visited)) {
            backtrack(mat, n, x, y + 1, path + "R", visited, result);
        }

        // Move Up
        if (isSafe(mat, n, x - 1, y, visited)) {
            backtrack(mat, n, x - 1, y, path + "U", visited, result);
        }

        // Backtrack (unmark visited)
        visited[x][y] = false;
    }

    // Check if move is safe
    private static boolean isSafe(int[][] mat, int n, int x, int y, boolean[][] visited) {
        return (x >= 0 && y >= 0 && x < n && y < n && mat[x][y] == 1 && !visited[x][y]);
    }

    // Driver
    public static void main(String[] args) {
        int[][] mat = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };
        int n = mat.length;

        ArrayList<String> paths = findPath(mat, n);

        if (paths.isEmpty()) {
            System.out.println("No path exists.");
        } else {
            System.out.println(paths);
        }
    }
}
/*
  There are two common ways to store the path in backtracking problems:

Mutable path (List/Stack) → you add a move before recursion, and remove it when backtracking.

Immutable path (String concatenation) → you pass a new String (path + "D") at every recursive call.

In my code:

I used option 2 (immutable string):
 */
