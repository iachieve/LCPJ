// public class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int memo[][] = new int[nums.length + 1][nums.length];
//         for (int[] l : memo) {
//             Arrays.fill(l, -1);
//         }
//         return lengthofLIS(nums, -1, 0, memo);
//     }
//     public int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo) {
//         if (curpos == nums.length) {
//             return 0;
//         }
//         if (memo[previndex + 1][curpos] >= 0) {
//             return memo[previndex + 1][curpos];
//         }
//         int taken = 0;
//         if (previndex < 0 || nums[curpos] > nums[previndex]) {
//             taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo);
//         }
​
//         int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo);
//         memo[previndex + 1][curpos] = Math.max(taken, nottaken);
//         return memo[previndex + 1][curpos];
//     }
// }
​
class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
​
    int[] maxLength = new int[nums.length];
    Arrays.fill(maxLength, 1);
​
    // By default the best answer is a length of 1
    int maximumSoFar = 1;
    
    // Test every possible end index of a longest increasing subsequence
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
        }
      }
​
      maximumSoFar = Math.max(maximumSoFar, maxLength[i]);
    }
​
    return maximumSoFar;
  }
}
