// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

// You may assume that you have an infinite number of each kind of coin.

// The answer is guaranteed to fit into a signed 32-bit integer.

class CoinChangeII {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int a[] : dp){
            Arrays.fill(a,-1);
        }

        int ans = helper(n-1,coins,amount,dp);
        return ans;
    }

    public int helper(int ind, int [] coins, int amount, int[][] dp){
        if(ind==0){
            if(amount%coins[ind]==0){
                return 1;
            }
            return 0;
        }

        if(dp[ind][amount]!=-1) return dp[ind][amount];

        int notTake = 0 + helper(ind-1,coins,amount,dp);
        int take = 0;
        if(coins[ind]<=amount){
            take = helper(ind,coins,amount - coins[ind],dp);
        }

        dp[ind][amount] = take + notTake;

        return take + notTake;
    }
}
