class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char [] arr1 = text1.toCharArray();
        char [] arr2 = text2.toCharArray();

        int n1 = arr1.length;
        int n2 = arr2.length;

        int [][] dp = new int[n1][n2];
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }

        int ans = helper(n1-1,n2-1,arr1,arr2,dp);
        return ans;
    }

    public int helper(int ind1, int ind2, char[] arr1, char[] arr2, int[][]dp){
        if(ind1<0 || ind2<0){
            return 0;
        }

        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];

        if(arr1[ind1]==arr2[ind2]){
            return dp[ind1][ind2] = 1 + helper(ind1-1,ind2-1,arr1,arr2,dp);
        }

        return dp[ind1][ind2] =  Math.max(helper(ind1,ind2-1,arr1,arr2,dp),
        helper(ind1-1,ind2,arr1,arr2,dp));
    }
}
