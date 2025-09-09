package arrays;

public class spiral {

    public static void print(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int startrow = 0;
        int endrow = n - 1;
        int startcol = 0;
        int endcol = m - 1;
        while (startrow <= endrow && startcol <= endcol) {
            // top
            for (int j = startcol; j <= endcol; j++) {
                System.out.print(matrix[startrow][j] + " ");
            }
            // right
            for (int i = startrow + 1; i <= endrow; i++) {
                System.out.print(matrix[i][endcol] + " ");
            }
            // bottom
            for (int j = endcol - 1; j >= startcol; j--) {
                if (startrow == endrow) {
                    break;
                }
                System.out.print(matrix[startrow][j] + " ");
            }
            // left
            for (int i = endrow - 1 - 1; i > startrow; i--) {
                if (startcol == endcol) {
                    break;
                }
                System.out.print(matrix[i][endcol] + " ");
            }
            startrow++;
            endrow--;
            startcol++;
            endcol--;
        }
    }

    public static void main(String args[]) {
        int matrix[][] = {{5, 4, 3}, {4, 2, 1}, {0, 5, 2}};
        print(matrix);
    }
}
/*
 
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans=new ArrayList<>();
        int startRow=0;
        int startCol=0;
        int endRow=matrix.length-1;
        int endCol=matrix[0].length-1;
        while(startRow<=endRow&&startCol<=endCol){
            for(int i=startCol;i<=endCol;i++){
                ans.add(matrix[startRow][i]);
            }
            for(int i=startRow+1;i<=endRow;i++){
                ans.add(matrix[i][endCol]);
            }
           if(startRow<endRow){
             for(int i=endCol-1;i>startCol;i--){
                ans.add(matrix[endRow][i]);
            }
           }
            if(startCol<endCol){
                for(int i=endRow;i>startRow;i--){
                ans.add(matrix[i][startCol]);
            }
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return ans;
    }
}


Common Mistakes to Avoid in Spiral Matrix

Using < in while loop instead of <=

while (startRow < endRow && startCol < endCol) will skip the last single row/col.

Always use <= so 1×n and m×1 matrices are handled.

Forgetting boundary checks for bottom row & left column

If startRow == endRow, bottom row loop will repeat the same row.

If startCol == endCol, left column loop will repeat the same column.

Fix: add

if (startRow < endRow) { ... }   // bottom row
if (startCol < endCol) { ... }   // left column

 */
