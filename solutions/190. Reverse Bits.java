public class Solution {
    // in real world scenario: Integer.reverse(n);
    
    // two rules:
    // In order to know if the current bit is 0 or 1, use (& 1)
    //      1 & 1 = 1  AND 0 & 1 = 0
    // In order to reverse a bit use (|0)
    //      1 | 0 = 1   AND  0|0 = 0
    public int reverseBits(int n) {
        // start result with zeros (000 0000)
        int result = 0;
        // the max int size in is 32 bits => 0->31 = 32 iteration
        for (int i = 0; i < 32; i++) {
            // get the last digit from n input  // 1 & 1 = 1 && 1 & 0 = 0
            int end = n & 1;
            // shift the right binary digit, in order to process the next bit
            n >>= 1;
            // append zero to result
            result <<= 1;
            // update result && update the result 0|1 = 1 && 0|0 = 0
            result |= end;
        }
        return result;
    }
}
​
​
​
​
    
