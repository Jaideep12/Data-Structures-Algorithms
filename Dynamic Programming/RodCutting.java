// Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

// Note: Consider 1-based indexing.

class Solution{
    public int cutRod(int price[], int n) {
        int dp [][] = new int [n][n+1];
        
        for(int a [] : dp){
            Arrays.fill(a,-1);
        }
        
        return helper(price,n,dp,n-1);
    }
    
    public int helper(int [] price, int n, int dp[][], int ind){
        
        if(ind==0){
            if(n>=1){
                return price[0] * n;
            }
            return 0;
        }
        
        
        if(dp[ind][n]!=-1) return dp[ind][n];
        
        int notTake = 0 + helper(price,n,dp,ind-1);
        
        int take = Integer.MIN_VALUE;
        int rodLength = ind+1;
        if(n>=rodLength){
            take = price[ind] + helper(price,n-rodLength,dp,ind);
        }
        
        dp[ind][n] = Math.max(take,notTake);
        
        return Math.max(take,notTake);
        
    }
}
