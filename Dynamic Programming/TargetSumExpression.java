// You are given an integer array nums and an integer target.

// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.

class TargetSumExpression {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int ans = helper(n-1,nums,target);
        return ans;
    }

    public int helper(int ind, int[] nums, int target){

        if(ind==0){
            int ways=0;
            if(target + nums[ind]==0){
                ways++;
            }
            if(target - nums[ind]==0){
                ways++;
            }
            return ways;
        }
        
        int plus = helper(ind-1,nums,target+nums[ind]);
        int minus = helper(ind-1,nums,target-nums[ind]);

        return plus + minus;
    }
}
