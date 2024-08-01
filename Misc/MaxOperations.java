// You are given a 
// binary string
//  s.

// You can perform the following operation on the string any number of times:

// Choose any index i from the string where i + 1 < s.length such that s[i] == '1' and s[i + 1] == '0'.
// Move the character s[i] to the right until it reaches the end of the string or another '1'. For example, for s = "010010", if we choose i = 1, the resulting string will be s = "000110".
// Return the maximum number of operations that you can perform.

class MaxOperations {
    public int maxOperations(String s) {
        int n = s.length(), cnt = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                ans += cnt;
                while (i < n && s.charAt(i) != '1') {
                    i++;
                }
            }
            cnt++;
        }
        return ans;
    }
}
