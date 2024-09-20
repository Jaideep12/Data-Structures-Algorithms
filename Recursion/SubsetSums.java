//first attempt
class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        int a[] = new int[n];
        
        int x=0;
        for(int b : arr){
            a[x++] = b;
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        helper(0,a,0,result);
        
        return result;
    }
    
    public void helper(int index,int[] a, int sum, 
    ArrayList<Integer>result){
        
        result.add(sum);
        
        if(index>=a.length){
            return;
        }
        
        for(int i=index;i<a.length;i++){
            sum+=a[i];
            helper(i+1,a,sum,result);
            sum-=a[i];
        }
    }
}
