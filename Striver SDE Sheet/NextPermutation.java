class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakpoint=-1;

        //Step 1 is to look for the longest prefix, we basically need the next greater number and for that we will start from the end
        // and search, for example 2 1 5 4 3 0 0
        // We need the first element from the right which is smaller than its right so that we can create the next permuation from here
        for(int i = n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                breakpoint = i;
                break;
            }
        }

        // If no such element is found that means we are at the last possible permutation hence reverse
        if(breakpoint == -1){
            reverse(nums,0,nums.length-1);
        }else{
            int next = -1;
            //Since we are looking for the next greater number we will look for the next element greater than breakpoint
            for(int i=n-1;i>=0;i--){
                if(nums[i]>nums[breakpoint]){
                    next = i;
                    break;
                }
            }

            int temp = nums[breakpoint];
            nums[breakpoint] = nums[next];
            nums[next] = temp;

            reverse(nums,breakpoint+1,nums.length-1);
        }
    }

    public void reverse(int [] nums, int start, int end){

        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
