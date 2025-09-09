package arrays;

public class diagonal_sum {

    public static void diagonal(int matrix[][]) {
        int n = matrix.length;
        int sum = 0;
        // for(int i=0;i<n;i++){
        //     //here the time complexity is high i.e o(n^2)
        //     for(int j=0;j<n;j++){
        //        //primary diagonal
        //         if(i==j){
        //             sum+=matrix[i][j];
        //         }
        //         // secondary diagonal
        //         if (i!=j) {
        //             if(i+j==n-1){
        //                 sum+=matrix[i][j];
        //             }
        //         }
        //     }
        // }
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
            if (n - 1 - i != i) {
                sum += matrix[i][n - 1 - i];

            }
        }
        System.out.println(sum);
    }

    public static void main(String args[]) {
        int matrix[][] = {{2, 5, 3}, {4, 2, 1}, {9, 4, 1}};
        diagonal(matrix);
    }
}
/*
 🔹 matrix[i][i]
This accesses the primary diagonal:

When i = 0 → matrix[0][0] = 2

When i = 1 → matrix[1][1] = 2

When i = 2 → matrix[2][2] = 1

🔹 matrix[i][n-1-i]
This accesses the secondary diagonal:

When i = 0 → matrix[0][2] = 3

When i = 1 → matrix[1][1] = 2 (same element as primary diagonal center)

When i = 2 → matrix[2][0] = 9

❗ Check to avoid double-counting the center
if (n-1-i != i)
 */
