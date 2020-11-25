// backtracking solution
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generatePowerset(0, new ArrayList<>(), nums, res);
        return res;
    }
     private void generatePowerset(int currIdx, List<Integer> selectedSoFar, int[] nums, List<List<Integer>> res) {
        if (currIdx == nums.length) {
            res.add(new ArrayList<>(selectedSoFar));
            return;
        }

        selectedSoFar.add(nums[currIdx]);
        generatePowerset(currIdx + 1, selectedSoFar, nums, res);
        selectedSoFar.remove(selectedSoFar.size() - 1);
        generatePowerset(currIdx + 1, selectedSoFar, nums, res);
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



// another recursion approach
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return powerset(nums, nums.length - 1);
    }
    
    public List<List<Integer>> powerset(int[] nums, int idx){
        if(idx < 0){
            List<List<Integer>> emptySet = new ArrayList<>();
            emptySet.add(new ArrayList<>());
            return emptySet;
        }
        int ele = nums[idx];
        List<List<Integer>> res = powerset(nums, idx - 1);
        int len = res.size();
        for(int i = 0; i < len; i++){
            List<Integer> tempSet = new ArrayList<>(res.get(i));
            tempSet.add(ele);
            res.add(tempSet);
        }
        return res;
    }
}
