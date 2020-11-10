class Solution {
    public int countPrimes(int n) {
    
        // Runtime: 12 ms, faster than 89.08% of Java online submissions for Count Primes.
        // Memory Usage: 37.6 MB, less than 5.93% of Java online submissions for Count Primes..
//         int counter = 0;
//         boolean[] seen = new boolean[n];
//         for(int i = 2; i < n; i++){
//             seen[i] = true;
//         }
//         for(int i = 2; i < n; i++){
//             if(seen[i]){
//                 counter++;
//                 if(i <= Math.sqrt(n))
//                     for(int j = i*i; j < n; j += i) seen[j] = false;
                
//             }
//         }
//         return counter;
        
        
        // Runtime: 7 ms, faster than 98.38% of Java online submissions for Count Primes.
        // Memory Usage: 37.7 MB, less than 5.93% of Java online submissions for Count Primes.
        
        // This solution is optimized by checking only the odd numbers.
        // If n is less than or equal to 2, there is only one prime element.
        // If n is greater than 2, there is at least one prime element (2).
        // Assume all odd numbers greater than or equal to 3 are prime numbers. 
        // Iterate through all the odd numbers from 3 to n. During each iteration, 
        //set all the odd product of the prime number to be non-prime number. 
        // (e.g. when iterating through 3, we know 9, 15, 18, ... cannot be prime number.) 
        // Note that we don't have to check the even number products.
​
        if (n <= 2) return 0;
        
        boolean[] notPrime = new boolean[n];
        int ct = 1;
        
        for (int i = 3; i < n; i+=2){
            if (!notPrime[i]) {
                ct++;
                for (int j = 3; i*j < n; j+=2){
                    notPrime[i*j] = true;
                }
            }
        }
        return ct;
    
    }
}
