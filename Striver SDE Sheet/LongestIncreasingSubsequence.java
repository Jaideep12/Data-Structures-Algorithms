class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int [n][n+1];
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }
        return helper(nums,0,-1,dp);
    }

    public int helper(int [] nums, int ind, int prev, int [][] dp){
        if(ind == nums.length){
            return 0;
        }

        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];

        int notTake = 0 + helper(nums,ind+1,prev,dp);

        int take = Integer.MIN_VALUE;
        if(prev==-1 || nums[ind]>nums[prev]){
            take = 1 + helper(nums,ind+1,ind,dp);
        }

        return dp[ind][prev+1] = Math.max(take,notTake);
    }
}
