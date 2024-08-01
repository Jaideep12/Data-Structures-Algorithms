// There is an array arr of heights of stone and Geek is standing at the first stone and can jump to one of the following: Stone i+1, i+2, ... i+k stone, 
// where k is the maximum number of steps that can be jumped and cost will be |hi-hj| is incurred, where j is the stone to land on. 
// Find the minimum possible total cost incurred before the Geek reaches the last stone.

class GeekKJumps {
    public int minimizeCost(int arr[], int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        
        return helper(arr,k,dp,n-1);
    }
    
    public int helper(int [] arr, int k, int [] dp, int ind){
        if(ind==0){
            return 0;
        }
        
        if(dp[ind]!=-1) return dp[ind];
        
        int min = Integer.MAX_VALUE;
        
        for(int i=1;i<=k;i++){
            if(ind-i>=0){
                int jump = helper(arr,k,dp,ind-i) + Math.abs(arr[ind-i]-arr[ind]);
                min = Math.min(min,jump);
                dp[ind] = min;
            }
        }
        return dp[ind];
    }
}
