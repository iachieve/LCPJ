class Solution {
    public boolean isPowerOfFour(int num) {
        // solution 1 O(Log n)
        // if(num == 0) return false;
        // while(num != 1){
        //     if(num % 4 != 0) return false;
        //     num /= 4;
        // }
        // return true;
        
        // solution 2 O(1)
        // return (Math.log(num) / Math.log(4)) % 1 == 0;
        
        
        // solution 3 0(1)
        // return num > 0 && ((num & (num - 1)) == 0) && (num - 1) % 3 == 0;
        
        // solution 4 o(1)
         int alternatingOddBitMask = 0x55555555; // 1010101010101010101010101010101
​
    boolean isNonZero = (num != 0);
    boolean hasSingleLeadingOneBit = (num & (num - 1)) == 0;
    boolean hasOnlyOddPositionedBits = (num & alternatingOddBitMask) == num;
​
    return isNonZero && hasSingleLeadingOneBit && hasOnlyOddPositionedBits;
    }
}
