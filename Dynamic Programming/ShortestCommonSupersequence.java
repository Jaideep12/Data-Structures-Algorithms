// 1092. Shortest Common Supersequence 
// Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

// A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int dp [][] = new int [m+1][n+1];


        //first create matrix for finding length
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

  int i = m;
  int j = n;

  String ans = "";

  while (i > 0 && j > 0) {
    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
      ans += str1.charAt(i-1);
      i--;
      j--;
    } else if (dp[i - 1][j] > dp[i][j - 1]) {
        ans += str1.charAt(i-1);
        i--;
    } else {
        ans += str2.charAt(j-1);
        j--;
    }
  }
  
  //Adding Remaing Characters - Only one of the below two while loops will run 
  
  while(i>0){
      ans += str1.charAt(i-1);
      i--;
  }
  while(j>0){
      ans += str2.charAt(j-1);
      j--;
  }

  String ans2=new StringBuilder(ans).reverse().toString();

  return ans2;
    }
}
