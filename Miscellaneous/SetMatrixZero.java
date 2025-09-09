package Miscellaneous;
// leetcode-- 73

class SetMatrixZero {

    public void setZeroes(int[][] matrix) {
        boolean firstrow = false;
        boolean firstcol = false;
        for (int i = 0; i < matrix.length; i++) { // this loop is for seeting first row and    first column to zeros and also marking true and false
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstrow = true;
                    }
                    if (j == 0) {
                        firstcol = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // now we trvaerse in the remaining matric except for first row and coumn
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // setting up first row and column now
        for (int i = 0; i < matrix[0].length; i++) {
            if (firstrow == true) {
                matrix[0][i] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (firstcol == true) {
                matrix[i][0] = 0;
            }
        }
    }
}
