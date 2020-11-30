// O(N!)time
// O(N^2)space
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        dfs(res, new int[n], 0, n);
        return res;
    }
​
    void dfs(List<List<String>> res, int[] path, int idx, int n) {
        for (int i = 0; i < n; i++) {
            path[idx] = i;
            if (isValid(path, idx)) {
                if (idx + 1 == n) addPath(res, path, n);
                else dfs(res, path, idx + 1, n);
            }
        }
    }
​
    private void addPath(List<List<String>> res, int[] path, int n) {
        List<String> t = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++)
                sb.append(j == path[i] ? "Q" : ".");
            t.add(sb.toString());
        }
        res.add(t);
    }
​
    boolean isValid(int[] path, int idx) {
        for (int i = 0; i < idx; ++i)
            if (path[idx] == path[i] || idx - i == Math.abs(path[idx] - path[i]))
                return false;
        return true;
    }
​
}
​
