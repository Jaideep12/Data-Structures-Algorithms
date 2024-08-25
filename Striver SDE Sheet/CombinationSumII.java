class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if (ind >= arr.length || target < 0) {
            return;
        }

        // Include current element
        ds.add(arr[ind]);
        findCombinations(ind + 1, arr, target - arr[ind], ans, ds);
        ds.remove(ds.size() - 1);

        // Skip identical elements
        int nextInd = ind + 1;
        while (nextInd < arr.length && arr[nextInd] == arr[ind]) {
            nextInd++;
        }

        // Exclude current element and its duplicates
        findCombinations(nextInd, arr, target, ans, ds);
    }
}
