package backtracking;

public class Nqueen {

    public static void ChessBoard(char board[][], int row) {
        // base
        if (row == board.length) {
            PrintBoard(board);
            return;
        }
        // kaam
        for (int j = 0; j < board[0].length; j++) {
            if (SafePosition(board, row, j)) {
                board[row][j] = 'Q';
                ChessBoard(board, row + 1);
                board[row][j] = 'X';
            }
        }
    }

    public static boolean SafePosition(char board[][], int row, int col) {
        //upwards
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // left upwards
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // right upwards
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void PrintBoard(char board[][]) {
        System.out.println("-------CHESS BOARD-------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'X';
            }
        }
        ChessBoard(board, 0);
    }
}
/*
 gfg style solution-->

 // User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        boolean board[][]=new boolean[n][n];
        int row=0;
        int col=board[0].length;
        helper(board,ans,temp,row,col);
        return ans;
    }
    public void helper(boolean board[][],ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int row,int col){
        if(row==board.length){
            ans.add(new ArrayList(temp));
            return;
        }
        for(int j=0;j<col;j++){
            if(isSafe(board,row,j)){
                board[row][j]=true;
                temp.add(j+1);
                helper(board,ans,temp,row+1,col);
                board[row][j]=false;
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isSafe(boolean board[][],int row, int col){
        for(int i=row-1;i>=0;i--){
            if(board[i][col]==true){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]==true){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
            if(board[i][j]==true){
                return false;
            }
        }
        return true;
    }
}
 */

 /*
  leetcode style solution-->

  class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean board[][] = new boolean[n][n];
        helper(board, ans, 0, n);
        return ans;
    }

    public void helper(boolean board[][], List<List<String>> ans, int row, int n){
        if(row == board.length){
            // Convert board to List<String>
            List<String> solution = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    sb.append(board[i][j] ? 'Q' : '.');
                }
                solution.add(sb.toString());
            }
            ans.add(solution);
            return;
        }

        for(int j = 0; j < n; j++){
            if(isSafe(board, row, j)){
                board[row][j] = true;      // place queen
                helper(board, ans, row + 1, n);
                board[row][j] = false;     // backtrack
            }
        }
    }

    public boolean isSafe(boolean board[][], int row, int col){
        int n = board.length;

        // Column upwards
        for(int i = row - 1; i >= 0; i--){
            if(board[i][col]) return false;
        }

        // Left diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j]) return false;
        }

        // Right diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(board[i][j]) return false;
        }

        return true;
    }
}

  */
