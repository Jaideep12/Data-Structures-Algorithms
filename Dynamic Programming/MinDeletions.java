// 583. Delete Operation for Two Strings
// Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

// In one step, you can delete exactly one character in either string.

class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int dp[][]=new int [n1][n2];

        for(int a [] : dp){
            Arrays.fill(a,-1);
        }

        int n = LCS(word1,word2,n1-1,n2-1,dp);

        return n1-n + n2-n;
    }

    public int LCS(String s1, String s2, int n1, int n2,int[][]dp){
        if(n1<0 || n2<0){
            return 0;
        }

        if(dp[n1][n2]!=-1) return dp[n1][n2];

        if(s1.charAt(n1)==s2.charAt(n2)){
            return dp[n1][n2]= 1+LCS(s1,s2,n1-1,n2-1,dp);
        }

        return dp[n1][n2]=Math.max(LCS(s1,s2,n1-1,n2,dp),LCS(s1,s2,n1,n2-1,dp));
    }
}
