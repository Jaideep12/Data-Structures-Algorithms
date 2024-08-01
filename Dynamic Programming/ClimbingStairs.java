// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

class ClimbingStairs {
    public int climbStairs(int n) {

        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);

        //There is only 1 way to go to the 0th or 1st step
        dp[0]=0;dp[1]=1;

        return helper(n,dp);
        
    }
    int helper(int n, int [] dp){

        if(n==0) return 1;
        if(n==1) return 1;

        if(dp[n]!=-1) return dp[n];

        //representing everything in terms of n and trying out all ways (top-down)
        return dp[n] = helper(n-1,dp)+helper(n-2,dp);
        
    }
}
