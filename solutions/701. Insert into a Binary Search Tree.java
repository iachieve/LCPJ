class Solution {
    
    // recursive solution   
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(val > root.val) root.right = insertIntoBST(root.right, val);
        else root.left = insertIntoBST(root.left, val);
        return root;
    }
    
    /*
    // iterative solution
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        
        TreeNode currNode = root;
        while(true){
            if(currNode.val <= val){
                if(currNode.right != null){
                    currNode = currNode.right;
                }else{
                    currNode.right = new TreeNode(val);
                    break;
                }
            }else{
                if(currNode.left != null){
                    currNode = currNode.left;
                } else{
                    currNode.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
    */
}