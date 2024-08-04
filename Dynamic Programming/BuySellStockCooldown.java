// 309. Best Time to Buy and Sell Stock with Cooldown
// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

// After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp [][] = new int [n][2];

        for(int a[] : dp){
            Arrays.fill(a,-1);
        }

        return helper(prices,dp,0,1);
    }

    public int helper(int [] prices, int [][] dp, int ind, int buy){
        if(ind>=prices.length){
            return 0;
        }

        if(dp[ind][buy]!=-1) return dp[ind][buy];

        if(buy==1){
            dp[ind][buy] = Math.max(-prices[ind] + helper(prices,dp,ind+1,0),
                helper(prices,dp,ind+1,1));
        }
        else{
            dp[ind][buy] = Math.max(prices[ind]+helper(prices,dp,ind+2,1),
            helper(prices,dp,ind+1,0));
        }

        return dp[ind][buy];
    }
}
