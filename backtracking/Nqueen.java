package backtracking;

public class Nqueen {

    public static void ChessBoard(char board[][], int row) {
        // base
        if (row == board.length) {
            PrintBoard(board);
            return;
        }
        // kaam
        for (int j = 0; j < board.length; j++) {
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
