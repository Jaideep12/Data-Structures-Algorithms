// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length-1;
        int dp [] = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = helper(nums,n,dp);
        return ans;
    }

    public int helper(int [] nums, int ind, int [] dp){
        if(ind==0) return nums[ind];
        if(ind<0) return 0;

        if(dp[ind]!=-1) return dp[ind];

        int pick = nums[ind] + helper(nums,ind-2,dp);
        int notPick = helper(nums,ind-1,dp);

        return dp[ind] = Math.max(pick,notPick);
    }
}
