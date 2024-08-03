// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dp = new int [m][n];
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }
        int ans = helper(m-1,n-1,grid,dp);
        return ans;
    }

    public int helper(int m, int n, int[][] grid, int[][] dp){
        if(m==0 && n==0){
            return grid[0][0];
        }

        //Returning a huge number so that this path does not get considered

        if(m<0 || n<0){
            return (int) Math.pow(10, 9);
        }

        if(dp[m][n]!=-1) return dp[m][n];

        int up = grid[m][n] + helper(m-1,n,grid,dp);
        int left = grid[m][n] + helper(m,n-1,grid,dp);

        return dp[m][n] = Math.min(up,left);
    }
}
