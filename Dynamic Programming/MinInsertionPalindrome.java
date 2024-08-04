// Given a string s. In one step you can insert any character at any index of the string.

// Return the minimum number of steps to make s palindrome.

// A Palindrome String is one that reads the same backward as well as forward.

//In this problem first we will find the longest palindromic subsequence, once found we will subtract that from the length
//the result will be the answer because at least that number of characters we will need to add.

class Solution {
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        String B = sb.reverse().toString();
        
        //System.out.println(B);
        
        int a = s.length();
        int b = B.length();

        int dp [][] = new int [a][a];
        
        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
                dp[i][j] = -1;
            }
        }
        
        int n = LCP(s,B,a-1,b-1,dp);
        
        return s.length()-n;
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
