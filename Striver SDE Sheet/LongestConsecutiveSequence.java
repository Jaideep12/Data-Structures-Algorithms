class Solution {
    public int longestConsecutive(int[] nums) {

        //My solution
        Map<Integer,Integer> values = new HashMap<>();

        if(nums.length==1) return 1;

        for(int i : nums){
            values.put(i,1);
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            int current = nums[i];
            if(values.containsKey(current-1)) continue;
            int count = 1;
            while(values.containsKey(current+1)){
                count++;
                max = Math.max(count,max);
                current++;
            }
            max = Math.max(count,max);
        }
        return max;
    }
}
