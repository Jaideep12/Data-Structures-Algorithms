// 88. Merge Sorted Array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0;i<m;i++){
            queue.offer(nums1[i]);
        }

        for(int i=0;i<n;i++){
            queue.offer(nums2[i]);
        }

        int x=0;
        while(!queue.isEmpty()){
            nums1[x++] = queue.poll();
        }

    }
}
