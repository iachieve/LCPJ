class Solution {
    public boolean isPowerOfThree(int n) {
        
        // brute force
       //  if(n == 0) return false;
       //     while(n != 1){
       //         if(n % 3 != 0) return false;
       //         n /= 3;
       //     }
       // return true;
        
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
​
/*
1,
3,
9,
27 
​
*/
​
