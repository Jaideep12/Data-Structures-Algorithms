// 1456. Maximum Number of Vowels in a Substring of Given Length

// Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

// Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

class Solution {
    public boolean isvowel(char c){
        return (c=='a' ||c=='e' || c=='i' || c=='o' || c=='u' );
    }
    public int maxVowels(String s, int k) {
        int N=s.length(),maxi=0,curr=0,j=0;

        for(int i=0;i<k;i++){
            if(isvowel(s.charAt(i)))
            curr++;
        }
        maxi=Math.max(maxi,curr);

         for(int i=k;i<N;i++){
             if(isvowel(s.charAt(j)))
             curr--;
             j++;

            if(isvowel(s.charAt(i)))
            curr++;

            maxi=Math.max(maxi,curr);
        }

        return maxi;
    }
}
