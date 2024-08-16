// Given an array arr[] and an integer k where k is smaller than the size of the array, the task is to find the kth smallest element in the given array. 
// It is given that all array elements are distinct.

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int a : arr){
            queue.offer(a);
        }
        
        int ans = 0;
        
        while(!queue.isEmpty() && k>0){
            ans = queue.poll();
            k=k-1;
        }
        
        return ans;
    }
