Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        // The algorithm relies on the fact that if there is an increasing triplet in the array, there must be two values, a and b, such that a < b. The algorithm keeps track of the two smallest values encountered (a and b). If it finds an element greater than both a and b, it means there is an increasing triplet.
        
        for (int num : nums) {
            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            } else {
                return true;
            }
        }
        
        return false;
    }
}
