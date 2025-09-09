package Miscellaneous;

// LEETCODE_498
class ZigZagMatrixTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length < 1) {
            return new int[0];
        }
        int n = mat.length;
        int m = mat[0].length;
        int ans[] = new int[n * m];
        int dir = 1;
        int row = 0;
        int col = 0;
        int idx = 0;

        while (idx < m * n) {
            ans[idx] = mat[row][col];
            idx++;

            if (dir == 1) { // going up-right
                if (col == m - 1) { // this order is must to maintain "row == 0"
                    row++;
                    dir = -1;
                } else if (row == 0) {
                    col++;
                    dir = -1;
                } else {
                    row--;
                    col++;
                }
            } else { // going down-left
                if (row == n - 1) {
                    col++;
                    dir = 1;
                } else if (col == 0) {
                    row++;
                    dir = 1;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return ans;
    }
}
/*

 ✅ Correct Order of Checks

At corners, more than one condition can be true.
At top-right corner → both row==0 and col==m-1 are true.
If you check row==0 first, you’ll take the wrong path (col++).
That’s why we must check col==m-1 before row==0.

 */
