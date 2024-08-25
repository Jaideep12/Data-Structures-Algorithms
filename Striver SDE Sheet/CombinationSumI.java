class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,target,result,new ArrayList<>(),0,0);
        return result;
    }

    public void backtrack(int[] candidates, int target,
        List<List<Integer>> result, List<Integer>current, int sum, int index){

            if(sum==target){
                result.add(new ArrayList<>(current));
                return;
            }

            if(index>=candidates.length){
                return;
            }

            if(sum>target){
                return;
            }

            current.add(candidates[index]);
            sum=sum+candidates[index];
            backtrack(candidates,target,result,current,sum,index);
            current.remove(current.size()-1);
            sum=sum-candidates[index];
            backtrack(candidates,target,result,current,sum,index+1);

    }
}
