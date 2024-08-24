class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int low = 0;
        int high = n-1;
        int left_max = 0;
        int right_max = 0;
        int water = 0;
        while(low < high){
            left_max = Math.max(height[low],left_max);
            right_max = Math.max(height[high],right_max);
            //we need to subtract the current height because above that only water will be stored
            water += left_max<right_max?left_max-height[low++]: right_max-height[high--];
        }
        return water;
    }
}
