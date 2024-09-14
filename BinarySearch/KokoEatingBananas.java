class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left=1;
        int right = findMax(piles);

        while(left<=right){
            int mid = left + (right-left)/2;

            int hours = calc(piles,mid);

            if(hours<=h){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public int calc(int [] piles, int mid){
        int ans=0;

        for(int i : piles){
            ans = ans + (int)Math.ceil((double)i/mid);
        }
        return ans;
        
    }

    public int findMax(int [] piles){
        int max = Integer.MIN_VALUE;
        for(int a : piles){
            max = Math.max(max,a);
        }
        return max;
    }
}
