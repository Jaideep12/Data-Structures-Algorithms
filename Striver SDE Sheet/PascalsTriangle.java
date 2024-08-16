// 118. Pascal's Triangle
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> first = new ArrayList<>();
        first.add(1);

        result.add(first);

        for(int i=1;i<numRows;i++){
            List<Integer> previous = result.get(i-1);

            List<Integer> current = new ArrayList<>();

            current.add(1);
            for(int j=1;j<previous.size();j++){
                current.add(previous.get(j-1)+previous.get(j));
            }
            current.add(1);

            result.add(current);
        }
        return result;
    }
}
