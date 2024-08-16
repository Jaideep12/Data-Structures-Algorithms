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

//Here is the constant space solution

public class Solution {
public void setZeroes(int[][] matrix) {
    boolean fr = false,fc = false;
    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[i][j] == 0) {
                if(i == 0) fr = true;
                if(j == 0) fc = true;
                matrix[0][j] = 0;
                matrix[i][0] = 0;
            }
        }
    }
    for(int i = 1; i < matrix.length; i++) {
        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
        }}
    }
    if(fr) {
        for(int j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = 0;
        }
    }
    if(fc) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
    }
}}  
