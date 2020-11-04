class Solution {
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        int size = matrix.length * matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1, right = matrix[0].length - 1, left = 0;
        while(left <=right && top <= bottom){
            for(int i = left; i <= right && res.size() <= size; i++) res.add(matrix[top][i]);
            top++;
            for(int i = top; i <= bottom && res.size() <= size; i++) res.add(matrix[i][right]);
            right--;
            for(int i = right; i >= left && res.size() <= size; i--) res.add(matrix[bottom][i]);
            bottom--;
            for(int i = bottom; i >= top && res.size() <= size; i--) res.add(matrix[i][left]);
            left++;
        }
        return res;
    }
}
