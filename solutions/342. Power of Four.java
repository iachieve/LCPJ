class Solution {
    public boolean isPowerOfFour(int num) {
        // solution 1
        return (Math.log(num) / Math.log(4)) % 1 == 0;
    }
}
