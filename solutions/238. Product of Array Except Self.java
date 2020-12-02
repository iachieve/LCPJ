/*
    Time Complexity: O(N), Space Complexity: O(N)
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
    Memory Usage: 52.2 MB, less than 20.40% of Java online submissions for Product of Array Except Self.
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] res = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        for (int i = 0; i < length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
