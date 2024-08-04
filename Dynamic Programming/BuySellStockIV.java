// 188. Best Time to Buy and Sell Stock IV
// You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

// Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length<=1) return 0;
        int [][][] dp = new int[prices.length][2][k+1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int n = helper(0,1,prices,dp,k);
        return n;
    }

    public int helper(int ind, int buy, int [] prices,int[][][]dp,int cap){

        if(cap==0){
            return 0;
        }

        if(ind==prices.length){
            return 0;
        }

        if(dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];

        int profit=0;

        if(buy==1){
            profit = Math.max((-prices[ind]+helper(ind+1,0,prices,dp,cap)),
            helper(ind+1,1,prices,dp,cap));
        }else{
            profit = Math.max((prices[ind]+helper(ind+1,1,prices,dp,cap-1)),helper(ind+1,0,prices,dp,cap));
        }
        return dp[ind][buy][cap]=profit;
    }
}
