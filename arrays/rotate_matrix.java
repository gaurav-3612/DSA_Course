package arrays;

public class rotate_matrix {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n / 2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                if (j != n - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i != n - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int matrix[][] = {{4, 6, 9}, {0, 1, 3}, {5, 8, 2}};
        rotate(matrix);
    }
}
