// Geek wants to climb from the 0th stair to the (n-1)th stair. At a time the Geek can climb either one or two steps. 
// A height[N] array is also given. Whenever the geek jumps from stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), 
// where abs() means the absolute difference. 
// return the minimum energy that can be used by the Geek to jump from stair 0 to stair N-1.

class GeekJump{
    public int minimumEnergy(int arr[],int N){
        int dp [] = new int[N];
        Arrays.fill(dp,-1);
        int ans = helper(arr,N-1,dp);
        return ans;
    }
    
    public int helper(int arr[],int N,int [] dp){
        if(N==0){
            return 0;
        }
        if(dp[N]!=-1) return dp[N];
        
        int left=0;
        int right=Integer.MAX_VALUE;
        
        left = helper(arr,N-1,dp) + Math.abs(arr[N]-arr[N-1]);
        if(N>1)
        right = helper(arr,N-2,dp) + Math.abs(arr[N]-arr[N-2]);
        
        return dp[N] = Math.min(left,right);
    }
}
