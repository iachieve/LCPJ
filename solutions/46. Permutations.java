class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> input = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        for(int n: nums) input.add(n);
        permute(0, res, input);
        return res;
    }
​
    public void permute(int i, List<List<Integer>> res, List<Integer> input){
        if(i == input.size())
            res.add(new ArrayList<>(input));
        for(int j = i; j < input.size(); ++j){
            Collections.swap(input, i, j);
            permute(i + 1, res, input);
            Collections.swap(input, i, j);
        }
    }
}
