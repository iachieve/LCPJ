class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0 || (nums.length == 1 && nums[0] == 0)) return new ArrayList();
        
        Arrays.sort(nums);
        Set<List<Integer>> allThreeSums = new HashSet<>();
        for(int i = 0; i < nums.length - 2; i++){
            findTwoSum(allThreeSums, nums, i);
        }
        return new ArrayList(allThreeSums);
    }
    private void findTwoSum(Set<List<Integer>> allThreeSums, int[] nums, int rootIndex){
        int left = rootIndex + 1;
        int right = nums.length - 1;
        while(left < right){
            int sum = nums[rootIndex] + nums[left] + nums[right];
            if(sum == 0){
                allThreeSums.add(Arrays.asList(nums[rootIndex], nums[left], nums[right]));
                left++;
                right--;
            }else if(sum < 0){
                left++;
            }else{
                right--;
            }
        }
    }
}
