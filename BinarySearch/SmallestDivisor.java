class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int left=1;
        int right = getMax(nums);

        int ans=-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            int sum = getSum(nums,mid);

            if(sum<=threshold){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }

    public int getSum(int [] nums, int mid){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int div = (int)Math.ceil((double)nums[i]/mid);
            sum=sum+div;
        }
        return sum;
    }

    public int getMax(int [] nums){
        int max = Integer.MIN_VALUE;
        for(int a : nums){
            max = Math.max(a,max);
        }
        return max;
    }
}
