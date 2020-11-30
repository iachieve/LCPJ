class Solution {
  
    
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList();
        backtrack(1, n, k, new LinkedList<>(), res);
        return res;
    }
    
    public void backtrack(int first, int n, int k, LinkedList<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k) res.add(new LinkedList(curr));
​
        for (int i = first; i < n + 1; ++i) {
            curr.add(i);
            backtrack(i + 1, n, k, curr, res);
            curr.removeLast();
        }
    }
    
    
    
    
}
