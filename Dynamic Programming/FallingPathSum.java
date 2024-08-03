// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

// A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. 
// Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

class FallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Integer.MAX_VALUE;
        for(int col=0;col<n;col++){
            int dp [][] = new int[m][n];
            for(int a[] : dp){
                Arrays.fill(a,-1);
            }
            min = Math.min(min,helper(matrix,0,col,dp));
        }
        return min;
    }

    public int helper(int [][] matrix, int m, int n,int [][]dp){
        if(n<0 || n>=matrix[0].length || m>=matrix.length){
            return (int)Math.pow(10,9);
        }

        if(m==matrix.length-1){
            return matrix[m][n];
        }
        
        if(dp[m][n]!=-1) return dp[m][n];

        int d1 = matrix[m][n] + helper(matrix,m+1,n,dp);
        int d2 = matrix[m][n] + helper(matrix,m+1,n+1,dp);
        int d3 = matrix[m][n] + helper(matrix,m+1,n-1,dp);

        return dp[m][n] = Math.min(d1,Math.min(d2,d3));
    }
}
