class Solution {    //  5   /   30
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> allThreeSums = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            findTwoSum(allThreeSums, nums, i);
        }
        return allThreeSums;
    }
                
    private void findTwoSum(List<List<Integer>> allThreeSums, int[] nums, int rootIndex){
        int left = rootIndex + 1, right = nums.length - 1;
        while(left < right){
            int sum = nums[rootIndex] + nums[left] + nums[right];
            if(sum == 0){
                allThreeSums.add(Arrays.asList(nums[rootIndex] , nums[left] , nums[right]));
                left++; right--;
                while(left < right && nums[left] == nums[left-1]) left++;
                while(left < right && nums[right] == nums[right+1]) right--;
            }else if(sum < 0) left++;
            else right--;
        }
    }
  
    
                
                
}
