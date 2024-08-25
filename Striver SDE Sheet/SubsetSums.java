class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        helper(arr,n,result,0,0);
        
        return result;
    }
    
    public void helper(ArrayList<Integer>arr, int n, ArrayList<Integer>result,
    int sum, int index){
        
        if(index==n){
            result.add(sum);
            return;
        }
        
        helper(arr,n,result,sum + arr.get(index), index+1);
        
        helper(arr,n,result,sum, index+1);
    }
}
