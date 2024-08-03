// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int a[] : dp){
            Arrays.fill(a,-1);
        }

        int ans = helper(n-1,coins,amount,dp);
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    public int helper(int ind, int [] coins, int amount, int[][] dp){
        if(ind==0){
            if(amount%coins[ind]==0){
                return amount/coins[ind];
            }
            return (int) Math.pow(10, 9);
        }

        if(dp[ind][amount]!=-1) return dp[ind][amount];

        int notTake = 0 + helper(ind-1,coins,amount,dp);
        int take = (int) Math.pow(10, 9);
        if(coins[ind]<=amount){
            take = 1 + helper(ind,coins,amount - coins[ind],dp);
        }

        dp[ind][amount] = Math.min(take,notTake);

        return Math.min(take,notTake);
    }
}
