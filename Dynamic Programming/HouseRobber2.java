// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n = nums.length;
        int [] dp1 = new int [n];
        Arrays.fill(dp1,-1);

        //we will divide the problem into 2 parts
        // As first and last are neighbours, we will first run from second last element to first and then last to second element
        //lastly we will take max of both this way we can avoid adjacents first and last.
        List<Integer>first = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            first.add(nums[i]);
        }

        int f = helper(first,first.size()-1,dp1);

        int [] dp2 = new int [n];
        Arrays.fill(dp2,-1);

        List<Integer>second = new ArrayList<>();
        for(int i=1;i<n;i++){
            second.add(nums[i]);
        }

        int s = helper(second,second.size()-1,dp2);

        return Math.max(f,s);

    }

    public int helper(List<Integer>input, int ind, int dp[]){
        if(ind==0) return input.get(ind);
        if(ind<0) return 0;

        if(dp[ind]!=-1) return dp[ind];

        int pick = input.get(ind) + helper(input,ind-2,dp);
        int notPick = 0 + helper(input,ind-1,dp);

        return dp[ind] = Math.max(pick,notPick);
    }
}
