// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements 
// in both subsets is equal or false otherwise.

class SubsetPartitionSum {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int a : nums){
            sum+=a;
        }

        boolean ans=false;
        int n = nums.length;
        if(sum%2==1){
            //If the sum is not even then it cannot be divided into 2 parts
            return false;
        }else{
          //If it is even, we can search for sum/2 only
            int k = sum/2;
            int dp[][] = new int[n][k + 1];
            for (int row[] : dp)
                Arrays.fill(row, -1);
            ans = helper(nums,k,n-1,dp);
        }
        return ans;
    }

    public boolean helper(int [] nums, int target, int ind, int [][] dp){
        if(target==0){
            return true;
        }

        if(ind==0 && nums[ind]==target){
            return true;
        }

        if(ind<0) return false;

        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        boolean take = false;
        boolean notTake = false;

        if(target>=nums[ind]){
            take = helper(nums,target-nums[ind],ind-1,dp);
        }
        notTake = helper(nums,target,ind-1,dp);

        dp[ind][target] = take || notTake ? 1 : 0;

        return take || notTake;
    }
}
