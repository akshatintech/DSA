class Solution {
    public void setZeroes(int[][] matrix) {
        int nrow = matrix.length;
        int ncol = matrix[0].length;


        boolean firstRowZero= false;
        boolean firstColZero = false;

        //Check if the first row contains 0
        for(int j =0 ;j < ncol ; j++){
            if(matrix[0][j] == 0){
                firstRowZero = true;
                break;
            }
        }

        //Check if the first col contains 0
        for(int i = 0;i < nrow ; i++){
            if(matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }


        //Using the first row and column as markers
        for(int i = 1; i < nrow; i++){
            for(int j  =1 ;j < ncol ; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < nrow; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < ncol; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < ncol; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < nrow; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        //Finally set the first row and first column to zero if needed
        if(firstRowZero){
            for (int j = 0; j < ncol; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < nrow; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}