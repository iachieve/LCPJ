class Solution {
    public List<List<Integer>> threeSum(int[] nums) {        
        Arrays.sort(nums);
        List<List<Integer>> allThreeSums = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip same result
            findTwoSum(allThreeSums, nums, i);
        }
        return allThreeSums;
    }
    private void findTwoSum(List<List<Integer>> allThreeSums, int[] nums, int rootIndex){
        int left = rootIndex + 1;
        int right = nums.length - 1;
        while(left < right){
            int sum = nums[rootIndex] + nums[left] + nums[right];
            if(sum == 0){
                allThreeSums.add(Arrays.asList(nums[rootIndex], nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) left++;  // skip same result
                while (left < right && nums[right] == nums[right + 1]) right--;  // skip same result
            }else if(sum < 0){
                left++;
            }else{
                right--;
            }
        }
    }
}
