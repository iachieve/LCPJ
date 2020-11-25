class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList();
    output.add(new ArrayList<Integer>());
    for (int num : nums) {
      List<List<Integer>> newSubsets = new ArrayList();
      for (List<Integer> curr : output) {
        newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
      }
      for (List<Integer> curr : newSubsets) {
        output.add(curr);
      }
    }
    return output;
  }
}


// iterative
  	List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		 List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(Integer ele: nums){
            int len = res.size();
            for(int i = 0; i < len; i++){
                List<Integer> set = new ArrayList<>(res.get(i));
                set.add(ele);
                res.add(set);
            }
            System.out.println(res);
        }
        return res;
    }
