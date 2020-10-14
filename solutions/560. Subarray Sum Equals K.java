class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> sumsMap = new HashMap<>();
        sumsMap.put(0, 1); // cover case if k exists in the nums array
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sumsMap.containsKey(sum - k)){
                count += sumsMap.get(sum - k);
            }
            sumsMap.put(sum, sumsMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
