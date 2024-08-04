// Given a string s, find the longest palindromic subsequence's length in s.

// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

//This problem is same as LCS, we need to take a second argument which will be the reverse of the given string

class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String B = sb.reverse().toString();
        
        int a = s.length();
        int b = B.length();

        int dp [][] = new int [a][a];
        
        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
                dp[i][j] = -1;
            }
        }
        
        int n = LCP(s,B,a-1,b-1,dp);
        
        return n;
    }

    public int LCP(String A, String B, int a, int b, int dp [][]){
        if(a<0 || b<0) return 0;

        if(dp[a][b]!=-1) return dp[a][b];
        
        if(A.charAt(a)==B.charAt(b)){
            return 1+LCP(A,B,a-1,b-1,dp);
        }
        
        return dp[a][b] = Math.max(LCP(A,B,a-1,b,dp),LCP(A,B,a,b-1,dp));
    }
}
