// All Paths With Sum (Optimal)
class Solution {
  public int pathSum(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }

    Map<Integer, Integer> prefixSumToTotalPrefixes = new HashMap<>();

    prefixSumToTotalPrefixes.put(0, 1);

    return findPathSum(root, 0, sum, prefixSumToTotalPrefixes);
  }

  private int findPathSum(
    TreeNode node,
    int rootToNodeSum,
    int target,
    Map<Integer, Integer> prefixSumToTotalPrefixes
  ) {
    if (node == null) {
      return 0;
    }

    rootToNodeSum += node.val;
    
    int amountToCompensateFor = rootToNodeSum - target;
    int totalPathsEndingAtThisNode = prefixSumToTotalPrefixes.getOrDefault(amountToCompensateFor, 0);
    
    int totalPathsWithThisPathsSum = prefixSumToTotalPrefixes.getOrDefault(rootToNodeSum, 0);
    prefixSumToTotalPrefixes.put(rootToNodeSum, totalPathsWithThisPathsSum + 1);

    int totalCompletedPathsInThisSubtree = totalPathsEndingAtThisNode
        + findPathSum(node.left, rootToNodeSum, target, prefixSumToTotalPrefixes)
        + findPathSum(node.right, rootToNodeSum, target, prefixSumToTotalPrefixes);

    prefixSumToTotalPrefixes.put(rootToNodeSum, prefixSumToTotalPrefixes.getOrDefault(rootToNodeSum, 0) - 1);

    return totalCompletedPathsInThisSubtree;
  }
}




/*

// All Paths With Sum (Brute Force)

class Solution {
  public int pathSum(TreeNode node, int targetSum) {
    if (node == null) {
      return 0;
    }

    
     // * We will traverse the whole tree and do a 'pathSum' query from each node
     // * serving as root to a subtree of the overarching tree.
     // * 
     // * 1.) Find the total path sums with the root of the overarching tree as the
     // * root to the "subtree"
     // * 
     // * 2.) We ask our left subtree, "How many path sums can you yield?", keeping the
     // * original 'targetSum' intact
     // * 
     // * 3.) We ask our right subtree, "How many path sums can you yield?", keeping
     // * the original 'targetSum' intact
     // * 
     // * We keep the 'targetSum' intact because it is the original query we are asking
     // * to every node in the whole tree.
    
    return totalPathSumsFromThisNode(node, targetSum) + pathSum(node.left, targetSum) + pathSum(node.right, targetSum);
  }

  
   // * Helper function that counts total path sums with the initial 'node' passed
   // * into the call being treated as the tree root.
  
  private int totalPathSumsFromThisNode(TreeNode node, int targetSum) {
    if (node == null) {
      return 0;
    }

    
     // * Does this node itself complete the running path? +1 if so, otherwise
     // * initialize to 0.
    
    int totalCompletedPathsFromThisNode = targetSum - node.val == 0 ? 1 : 0;

    
     // * How many more paths can be completed from this node? Reduce the subproblem &
     // * recurse.
    
    totalCompletedPathsFromThisNode += totalPathSumsFromThisNode(node.left, targetSum - node.val)
        + totalPathSumsFromThisNode(node.right, targetSum - node.val);

    return totalCompletedPathsFromThisNode;
  }
}

*/





// package dev.practice.one;

//class Solution {
//    public int pathSum(TreeNode node, int target) {
//        if (node == null) return 0;
//        return pathSumCount(node, target) + pathSum(node.left, target) + pathSum(node.right, target);
//    }
//
//    private int pathSumCount(TreeNode node, int target) {
//        if (node == null)  return 0;
//
//        int count = target - node.val == 0 ? 1 : 0;
//
//        count += pathSumCount(node.left, target - node.val)
//                + pathSumCount(node.right, target - node.val);
//
//        return count;
//    }
//}

//import java.util.HashMap;
//import java.util.Map;
//
//class Solution {
//
//    public int pathSum(TreeNode root, int target) {
//        if (root == null) return 0;
//        Map<Integer, Integer> prefixSumMap = new HashMap<>();
//        prefixSumMap.put(0, 1);
//        return findPathSum(root, 0, target, prefixSumMap);
//    }
//
//    private int findPathSum(TreeNode node, int sum, int target, Map<Integer, Integer> prefixSumMap) {
//        if (node == null) return 0;
//        sum += node.val;
//
//        prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
//
//        prefixSumMap.entrySet().forEach(entry->{
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        });
//
//        int count =
//                prefixSumMap.getOrDefault(sum - target, 0)
//                + findPathSum(node.left, sum, target, prefixSumMap)
//                + findPathSum(node.right, sum, target, prefixSumMap);
//
//        prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) - 1);
//
//        return count;
//    }
//}
