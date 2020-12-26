/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    private TreeNode root;
    private List<Integer> sortedList; 
    int pointer;
    public BSTIterator(TreeNode root) {
        this.root = root;
        sortedList = new ArrayList<>(); 
        flatten(this.root);
        pointer = -1;
    }
    private void flatten(TreeNode node){
        if (node == null) return;
        flatten(node.left);
        sortedList.add(node.val);
        flatten(node.right);
    }
    public int next() {
        if (hasNext()) return this.sortedList.get(++this.pointer);
        return -1;
    }
    
    public boolean hasNext() {
        return this.pointer + 1 < this.sortedList.size();
    }
}
​
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
