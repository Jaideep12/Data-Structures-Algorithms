// You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

// Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The testcases are generated so that the answer will be less than or equal to 2 * 109.

class UniquePathsObstacle {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp [][] = new int[m][n];
        for(int a [] : dp){
            Arrays.fill(a,-1);
        }

        return helper(m-1,n-1,grid,dp);
    }

    public int helper(int m, int n, int [][] grid, int[][]dp){
        
        if(m>=0 && n>=0 && grid[m][n]==1){
            return 0;
        }

        if(m==0 && n==0){
            return 1;
        }

        if(m<0 || n<0){
            return 0;
        }

        if(dp[m][n]!=-1) return dp[m][n];

        int up = helper(m-1,n,grid,dp);
        int left = helper(m,n-1,grid,dp);

        return dp[m][n] = up+left;
    }
}
