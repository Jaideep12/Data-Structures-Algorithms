class Solution {
    public int findKRotation(List<Integer> arr) {
        int a[] = new int [arr.size()];
        int x=0;
        for(int t : arr){
            a[x++] = t;
        }
        
        int left=0;
        int right = a.length-1;
        
        int min = Integer.MAX_VALUE;
        int index=-1;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            
            if(a[mid]>=a[left]){
                if(a[left]<min){
                    min = a[left];
                    index=left;
                }
                left = mid+1;
            }else{
                if(a[mid]<min){
                    min = a[mid];
                    index=mid;
                }
                right=mid-1;
            }
        }
        
        return index;
    }
}
