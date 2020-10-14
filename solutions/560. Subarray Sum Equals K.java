class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> sumsArr = new HashMap<>();
        sumsArr.put(0, 1); // cover case if k exists in the nums array
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sumsArr.containsKey(sum - k)){
                count += sumsArr.get(sum - k);
            }
            sumsArr.put(sum, sumsArr.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
