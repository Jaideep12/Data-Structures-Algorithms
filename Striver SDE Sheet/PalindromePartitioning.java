class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s,result,new ArrayList<String>(),0);
        return result;
    }

    public void helper(String s,List<List<String>> result,List<String> current,int index){

        if(index==s.length()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                current.add(s.substring(index,i+1));
                helper(s,result,current,i+1);
                current.remove(current.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
