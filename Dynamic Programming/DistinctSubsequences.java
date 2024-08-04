// 115. Distinct Subsequences
// Given two strings s and t, return the number of distinct subsequences of s which equals t.

// The test cases are generated so that the answer fits on a 32-bit signed integer.

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int dp[][] = new int [m+1][n+1];
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }

        return helper(s,t,m-1,n-1,dp);
    }

    public int helper(String s, String t, int m, int n, int dp[][]){

        if(n<0){
            return 1;
        }

        if(m<0){
            return 0;
        }

        if(dp[m][n]!=-1) return dp[m][n];

        if(s.charAt(m)==t.charAt(n)){
            return dp[m][n] = helper(s,t,m-1,n-1,dp) + helper(s,t,m-1,n,dp);
        }

        return dp[m][n] = helper(s,t,m-1,n,dp);
    }
}
