// 123. Best Time to Buy and Sell Stock III
// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete at most two transactions.

// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int [][][] dp = new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int n = helper(0,1,prices,dp,2);
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
