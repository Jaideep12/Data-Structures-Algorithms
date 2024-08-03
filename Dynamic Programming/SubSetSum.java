// Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 

class SubSetSum{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        int dp[][] = new int[N][sum + 1];

        // Initialize DP table with -1 (unprocessed)
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return helper(N-1,arr,sum,dp);
    }
    
    public static boolean helper(int ind, int[] arr, int sum,int [][] dp){
        if(sum==0){
            return true;
        }
        
        if(ind==0 && arr[ind]==sum){
            return true;
        }
        
        if(ind<0) return false;
        
        if(dp[ind][sum]!=-1){
            if(dp[ind][sum]==1){
                return true;
            }
            return false;
        }
        
        boolean take = false;
        boolean notTake = false;
        
        if(sum>=arr[ind]);
        take = helper(ind-1,arr,sum-arr[ind],dp);
        
        notTake = helper(ind-1,arr,sum,dp);
        dp[ind][sum] = take || notTake ? 1 : 0;
        
        return take || notTake;
    }
}
