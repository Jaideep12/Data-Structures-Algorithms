// 73. Set Matrix Zeroes

//This solution has a space complexity of O(2n)
class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        //Here we will store all rows and columns which need to be made 0
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        //Converting elements in all rows to 0
        for(int i : rows){
            for(int j=0;j<c;j++){
                matrix[i][j] = 0;
            }
        }

        //Converting elements in all cols to 0
        for(int i=0;i<r;i++){
            for(int j : cols){
                matrix[i][j] = 0;
            }
        }
    }
}
