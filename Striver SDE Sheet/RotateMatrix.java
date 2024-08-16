class Solution {
    public void rotate(int[][] matrix) {
        //to rotate a matrix by 90 first take transpose then reverse;
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=i;j<r;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<r/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][c-1-j];
                matrix[i][c-1-j] = temp;
            }
        }
    }
}
