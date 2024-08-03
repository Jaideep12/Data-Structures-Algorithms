// Given a triangle array, return the minimum path sum from top to bottom.

// For each step, you may move to an adjacent number of the row below. More formally, 
// if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int [n][n];
        for(int a [] : dp){
            Arrays.fill(a,-1);
        }
        int ans = helper(triangle,0,0,dp);
        return ans;
    }

    public int helper(List<List<Integer>> triangle,int i,int j,int [][]dp){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }

        if(dp[i][j]!=-1) return dp[i][j];

        int d1 = triangle.get(i).get(j) + helper(triangle,i+1,j,dp);
        int d2 = triangle.get(i).get(j) + helper(triangle,i+1,j+1,dp);

        return dp[i][j] = Math.min(d1,d2);
    }
}
