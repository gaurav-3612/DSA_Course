package arrays;

public class transpose {
    public static void transpose(int matrix[][]){
        int n = matrix.length;
        int m=matrix[0].length;
        int tran[][]=new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                tran[j][i]=matrix[i][j];
            }
        }
        for(int i=0;i<tran.length;i++){
            for(int j=0;j<tran[0].length;j++){
                System.out.print(tran[i][j]+"  ");
            }
            System.out.println();
        }

    }
    public static void main(String args[]){
        int matrix[][]={{5,3,1},{9,4,6}};
        transpose(matrix);
    }
}
