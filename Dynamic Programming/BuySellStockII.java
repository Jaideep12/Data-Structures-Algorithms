// 122. Best Time to Buy and Sell Stock II
// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

// On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

// Find and return the maximum profit you can achieve.

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int [][] dp = new int[prices.length][2];
        for(int [] a : dp){
            Arrays.fill(a,-1);
        }
        int n = helper(0,1,prices,dp);
        return n;
    }

    public int helper(int ind, int buy, int [] prices,int[][]dp){
        if(ind==prices.length){
            return 0;
        }

        if(dp[ind][buy]!=-1) return dp[ind][buy];

        int profit=0;

        if(buy==1){
            profit = Math.max((-prices[ind]+helper(ind+1,0,prices,dp)),
            helper(ind+1,1,prices,dp));
        }else{
            profit = Math.max((prices[ind]+helper(ind+1,1,prices,dp)),helper(ind+1,0,prices,dp));
        }
        return dp[ind][buy]=profit;
    }
}
