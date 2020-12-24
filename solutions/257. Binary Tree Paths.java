class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, paths, "");
        return paths;
    }
    public void constructPaths(TreeNode root, List<String> paths, String path) {
        if (root != null) {
            path += Integer.toString(root.val);
            if (root.left == null && root.right == null) {
                paths.add(path);
            }else{
                path += "->";
                constructPaths(root.left, paths, path);
                constructPaths(root.right, paths, path);
            }
        }
    }
    
}
