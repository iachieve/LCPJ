class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0;
        int right = rows * columns - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid/columns][mid%columns];
            if(target == midElement){
                return true;
            }else if(target > midElement){
                left = mid + 1;
            }else if (target < midElement){
                right = mid - 1;
            }
        }
        return false;
    }
}
