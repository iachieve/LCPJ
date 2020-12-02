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


/*
Space Complexity: O(N), Time Complexity: O(1)
Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
Memory Usage: 49.6 MB, less than 63.69% of Java online submissions for Product of Array Except Self.
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        res[0] = 1;
        for (int i = 1; i < length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right *= nums[i];
        }

        return res;
    }
}
