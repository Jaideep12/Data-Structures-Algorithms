Given an array arr of N integers, the task is to replace each element of the array by its rank in the array. 
The rank of an element is defined as the distance between the element with the first element of the array when the array is arranged in ascending order. 
If two or more are same in the array then their rank is also the same as the rank of the first occurrence of the element. 

class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        Map<Integer,Integer> values = new HashMap<>();
        
        for(int a : arr){
            q.add(a);
        }
        
        int rank=1;
        
        while(!q.isEmpty()){
            int element = q.poll();
            if(!values.containsKey(element)){
                values.put(element,rank);
                rank++;
            }
        }
        
        //System.out.println("Map = "+values);
        
        for(int i=0;i<N;i++){
            arr[i] = values.get(arr[i]);
        }
        
        return arr;
  }
}
