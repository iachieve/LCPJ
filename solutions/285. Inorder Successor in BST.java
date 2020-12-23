​
class Solution {
    // Left Parent Right
    public TreeNode inorderSuccessor(TreeNode a, TreeNode b) {
        
    TreeNode res = null;
       TreeNode cur = a;
       while(cur!=null){
           if(cur.val > b.val){ // meaning parent or right
               res=cur;
               cur=cur.left;
            }else{
               cur=cur.right;
           }
       }
       return res;
    }
}
