// 215. Kth Largest Element in an Array
// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Can you solve it without sorting?

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i : nums){
            q.add(i);
        }

        int ans=0;
        while(!q.isEmpty() && k>0){
            ans=q.poll();
            k--;
        }
        return ans;
    }
}
