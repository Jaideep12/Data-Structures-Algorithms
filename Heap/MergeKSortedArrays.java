// Given k sorted arrays arranged in the form of a matrix of size k * k. The task is to merge them into one sorted array. 
// Return the merged sorted array ( as a pointer to the merged sorted arrays in cpp, as an ArrayList in java, and list in python).

// Input: k = 3, arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
// Output: 1 2 3 4 5 6 7 8 9
// Explanation: Above test case has 3 sorted arrays of size 3, 3, 3 arr[][] = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]. The merged list will be [1, 2, 3, 4, 5, 6, 7, 8, 9].

class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                queue.offer(arr[i][j]);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!queue.isEmpty()){
            result.add(queue.poll());
        }
        
        return result;
    }
}
