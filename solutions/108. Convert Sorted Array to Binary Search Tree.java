​
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return minHeightBST(nums, 0, nums.length);
    }
    public TreeNode minHeightBST(int[] nums, int s, int e) {
        if (s >= e) return null;
        int mid = s + ((e - s) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = minHeightBST(nums, s, mid);
        root.right = minHeightBST(nums, mid + 1, e);
        return root;
    }
}
​
/*
        [-10,-3,0,5,9]
        length = 4 ,mid 3 (0)
        start + ((end - start) / 2)
        0 + (4 / 2) = 2
        
*/
