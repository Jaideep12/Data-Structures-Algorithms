class Solution {

    static int findFloor(long arr[], int n, long x) {
        int ans = -1;
        int left=0;
        int right = n-1;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            
            if(arr[mid]>x){
                right = mid-1;
            }else{
                ans = mid;
                left=mid+1;
            }
        }
        return ans;
    }
}
