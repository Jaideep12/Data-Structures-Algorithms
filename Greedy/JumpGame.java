// 55. Jump Game

// You are given an integer array nums. You are initially positioned at the array's first index, 
// and each element in the array represents your maximum jump length at that position.

// Return true if you can reach the last index, or false otherwise.

class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;
        int last = n-1;
        for(int i=n-1;i>=0;i--){
            if(i + nums[i]>=last){
                last = i;
            }
        }
        return last==0;
    }
}
