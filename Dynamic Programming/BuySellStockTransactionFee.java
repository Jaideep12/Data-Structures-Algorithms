// You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

// Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

// Note:

// You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
// The transaction fee is only charged once for each stock purchase and sale.

//Note - this is not a space optimized solution hence will fail for space constraints

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int [][][] dp = new int[n][2][fee+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return helper(prices,0,1,fee,dp);
    }

    public int helper(int [] prices, int ind, int buy, int fee, int [][][]dp){
        if(ind == prices.length){
            return 0;
        }

        if(dp[ind][buy][fee]!=-1) return dp[ind][buy][fee];

        if(buy==1){
            dp[ind][buy][fee] = Math.max(-prices[ind] + helper(prices,ind+1,0,fee,dp)
            ,helper(prices,ind+1,1,fee,dp));
        }else{
            dp[ind][buy][fee] = Math.max((prices[ind] - fee) + helper(prices,ind+1,1,fee,dp)
            ,helper(prices,ind+1,0,fee,dp));
        }
        return dp[ind][buy][fee];
    }
}
