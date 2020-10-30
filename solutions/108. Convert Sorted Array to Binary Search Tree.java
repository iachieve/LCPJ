class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
            return buildMinHeighBST(nums, 0, nums.length);
    }
    
    private TreeNode buildMinHeighBST(int[] nums, int left, int right) {
    if (left >= right) return null;
​
    int middleIndex = left + ((right - left) / 2);
    TreeNode newNode = new TreeNode(nums[middleIndex]);
​
    newNode.left = buildMinHeighBST(nums, left, middleIndex);
    newNode.right = buildMinHeighBST(nums, middleIndex + 1, right);
​
    return newNode;
  }
}
​
