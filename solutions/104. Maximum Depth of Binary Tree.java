//             int qSize = queue.size();
//             for (int i = 0; i < qSize; i++) {
//                 root = queue.poll();
//                 if (root.left != null) queue.add(root.left);
//                 if (root.right != null) queue.add(root.right);
//             }
//             depth++;
//         }
//         return depth;
//     }
// }
​
/*
// recursive
class Solution {
     public int maxDepth(TreeNode root) {
         if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
     }
}
*/
// recursive
class Solution {
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
72
73
74
75
76
77
78
79
