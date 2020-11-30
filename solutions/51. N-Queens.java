// O(N!)time
// O(N^2)space
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        dfs(res, new int[n], 0, n);
        return res;
    }
    
     //pos[i]  mean we choose pos[i] in line i. 
     //(i , pos[i])
    void dfs(List<List<String>> res, int[] pos, int index, int n) {
        for (int i = 0; i < n; i++) {
            pos[index] = i;
            if (checkLegal(pos, index, i)) {
                if (index + 1 == n) {
                    List<String> t = new LinkedList<>();
                    for (int j = 0; j < n; j++) {
                        StringBuilder sb = new StringBuilder();
                        for (int k = 0; k < n; k++) {
                            sb.append(k == pos[j] ? "Q" : ".");
                        }
                        t.add(sb.toString());
                    }
                    res.add(t);
                } else {
                    dfs(res, pos, index + 1, n);
                }
            }
        }
    }
​
    boolean checkLegal(int[] pos, int index, int i) {
        for (int j = 0; j < index; j++) {
            if (pos[index] == pos[j]
                    || Math.abs(index - j) == Math.abs(pos[index] - pos[j])) {
                return false;
            }
        }
        return true;
    }
​
}
