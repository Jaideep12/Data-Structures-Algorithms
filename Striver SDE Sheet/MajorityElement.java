//This is a 2 pointer approach, brute force approach would be to get count of every number and then another pass to get the count which is more than n/2
class Solution {
    public int majorityElement(int[] nums) {

        Arrays.sort(nums);

        int target = nums.length/2;

        int a=0;
        int b=0;

        while(b<nums.length){
            while(b<nums.length && nums[a]==nums[b]){
                b++;
            }
            int len = 0;
            if(b==nums.length-1){
                len = b-a+1;
            }else{
                len=b-a;
            }
            if(len>target){
                return nums[a];
            }else{
                a=b;
            }
        }
        return -1;
    }
}
