// Given a set of N items, each with a weight and a value, represented by the array w and val respectively. Also, a knapsack with weight limit W.
// The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
// Note: Each item can be taken any number of times.

class Solution{
    static int knapSack(int n, int W, int val[], int wt[])
    {
        int dp[][] = new int[n][W+1];
        
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }
        
        int ans = helper(n-1,W,wt,val,dp);
        return ans;
    }
    
    public static int helper(int ind, int W, int [] wt, int [] val, int [][] dp){
        if(ind==0){
            if(wt[ind]<=W){
                return ((int) (W / wt[0])) * val[0];
            }
            return 0;
        }
        
        if(dp[ind][W]!=-1) return dp[ind][W];
        
        int notTake = 0 + helper(ind-1,W,wt,val,dp);
        int take = Integer.MIN_VALUE;
        
        if(wt[ind]<=W){
            take = val[ind] + helper(ind,W-wt[ind],wt,val,dp);
        }
        
        dp[ind][W] = Math.max(take,notTake);
        
        return Math.max(take,notTake);
    }
}
