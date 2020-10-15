class Solution {
    public boolean isPalindrome(int x) {
if (x < 0) return false;
        int len = (int) Math.log10(x) + 1;
        int mask = (int) Math.pow(10, len - 1);
​
        for (int i = 0; i < len / 2; i++) {
            int lsd = x % 10;
            int msd = x / mask;
​
            if (lsd != msd) return false;
​
            x = x % mask;
            x = x / 10;
            mask = mask / 100;
        }
        return true;
    }
}
