class Solution {
    // 2     10
    public int missingNumber(int[] nums) {
        int m = nums.length;
        for(int i = 0; i < nums.length; i++) m^= i^nums[i];
        return m;
    }
}
