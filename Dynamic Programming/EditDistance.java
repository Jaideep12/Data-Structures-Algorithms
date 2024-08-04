// 72. Edit Distance
// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

// You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character

class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int dp[][] = new int[n1][n2];

        for(int a[] : dp){
            Arrays.fill(a,-1);
        }

        int n = LCS(word1,word2,n1-1,n2-1,dp);

        return n;
    }

    public int LCS(String s1,String s2,int n1,int n2,int[][]dp){
        if(n1<0){
            return n2+1;
        }
        if(n2<0){
            return n1+1;
        }

        if(dp[n1][n2]!=-1) return dp[n1][n2];

        if(s1.charAt(n1)==s2.charAt(n2)){
            return dp[n1][n2] = LCS(s1,s2,n1-1,n2-1,dp);
        }

        //f(i,j-1) signifies insert operation as insertion will be done after i hence i will not move
        //f(i-1,j) signifies delete operation as i will move after deletion
        //f(i-1,j-1) signifies replace

        return dp[n1][n2] = 1 + Math.min(Math.min(LCS(s1,s2,n1-1,n2,dp),LCS(s1,s2,n1,n2-1,dp)),LCS(s1,s2,n1-1,n2-1,dp));
    }
}
