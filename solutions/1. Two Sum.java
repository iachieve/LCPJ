class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; ++i) {
                int delta = target - nums[i];
                if (map.containsKey(delta)) {
                   return new int[] {map.get(delta), i};
                } else{
                    map.put(nums[i], i);
                }
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }
}
