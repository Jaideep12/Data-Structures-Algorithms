class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        int expected = nums.length/3;

        int a=0;
        int b=0;

        while(b<nums.length){
            while(b<nums.length && nums[a] == nums[b]){
                b++;
            }

            int len = b-a;
            if(len>expected){
                result.add(nums[a]);
            }

            a=b;
        }
        return result;
    }
}
