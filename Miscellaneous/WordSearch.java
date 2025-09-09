package Miscellaneous;
// leetcode-- 79

class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        // Base case: found whole word
        if (index == word.length()) {
            return true;
        }

        // Out of bounds OR mismatch
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark visited (temporary change)
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore 4 directions
        boolean found = dfs(board, word, row + 1, col, index + 1)
                || dfs(board, word, row - 1, col, index + 1)
                || dfs(board, word, row, col + 1, index + 1)
                || dfs(board, word, row, col - 1, index + 1);

        // Backtrack (restore original character)
        board[row][col] = temp;

        return found;
    }
}
/*
 ❌ Common Mistakes in Word Search (Leetcode 79)

No visited marking

Bug: Same cell can be reused multiple times (e.g., "AAA" on [["A","A"]]).

Fix: Temporarily mark visited cell (e.g., board[row][col] = '#').

No backtracking (restore step)

Bug: Once marked, cell is never usable again in other paths.

Fix: After exploring, restore the character (board[row][col] = temp).

Wrong base case

Bug: Returning true only when index == word.length() - 1.

Fix: Correct base case is if (index == word.length()) return true;.

Out-of-bounds check after accessing

Bug: Accessing board[row][col] first may throw IndexOutOfBounds.

Fix: Always check bounds before comparing.
 */
