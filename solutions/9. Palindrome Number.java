class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int len = (int)Math.floor(Math.log10(x)) + 1;
        int mask = (int)Math.pow(10, len - 1);
        for(int i = 0; i < (len/2); i++){
            int lastDigit = x % 10;
            int firstDigit = x / mask;
            if(lastDigit != firstDigit) return false;
            x %= mask;
            x /=10;
            mask /= 100;
        }
        return true;
    }
}
