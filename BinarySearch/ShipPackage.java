class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=getMax(weights);
        int right = getSum(weights);
        int ans=-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int d = getDays(weights,mid);

            if(d<=days){
                right = mid-1;
                ans=mid;
            }else if (d > days){
                left = mid+1;
            }
        }
        return ans;
    }

    public int getMax(int [] weights){
        int max = Integer.MIN_VALUE;
        for(int i : weights){
            max = Math.max(max,i);
        }
        return max;
    }

    public int getDays(int [] weights, int mid){
        int days=1;
        int load =0;

        for(int i=0;i<weights.length;i++){
            if(load + weights[i] > mid){
                days++;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        return days;
    }

    public int getSum(int [] weights){
        int sum = 0;
        for(int a : weights){
            sum+=a;
        }
        return sum;
    }
}
