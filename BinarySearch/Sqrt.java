class Solution {
    long floorSqrt(long n) {
        long left = 1;
        long right = n;
        
        long ans = 0;
        while(left<=right){
            long mid = left + (right-left)/2;
            
            if(mid * mid == n){
                return mid;
            }else if(mid * mid < n){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }
}
