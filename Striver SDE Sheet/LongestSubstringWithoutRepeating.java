// 3. Longest Substring Without Repeating Characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> values = new HashSet<>();
        int max = 0;
        int left=0;
        int right=0;

        while(right<s.length()){
            char ch = s.charAt(right);

            if(!values.contains(ch)){
                values.add(ch);
                max = Math.max(max,right-left+1);
                right++;
            }else{
                values.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}
