class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int len = (int) Math.floor(Math.log10(x)) + 1;
        int mask = (int)Math.pow(10, len - 1);
        for(int i = 0; i < len / 2; i++){
            int msd = x / mask;
            int lsd = x % 10;
            if(msd != lsd) return false;
            x = x % mask;
            x = x / 10;
            mask = mask / 100;
        }
        return true;
    }
}
