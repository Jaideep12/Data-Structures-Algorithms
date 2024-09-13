class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        int first = firstOccurrence(nums,target,n);
        int last = lastOccurrence(nums,target,n);

        int [] res = new int [2];
        res[0]=first;
        res[1]=last;

        return res;
    }

    public int firstOccurrence(int[] nums, int target, int n){
        int left = 0;
        int right = n-1;
        int first=-1;
        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target){
                first = mid;
                right=mid-1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return first;
    }

    public int lastOccurrence(int[] nums, int target, int n){
        int left = 0;
        int right = n-1;
        int last=-1;
        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target){
                last = mid;
                left=mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return last;
    }
}
