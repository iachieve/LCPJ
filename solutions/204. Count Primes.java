class Solution {
    
    public int countPrimes(int n) {
        int counter = 0;
        boolean[] seen = new boolean[n];
        for(int i = 2; i < n; i++){
            seen[i] = true;
        }
        for(int i = 2; i < n; i++){
            if(seen[i]){
                counter++;
                if(i <= Math.sqrt(n))
                    for(int j = i*i; j < n; j += i) seen[j] = false;
                
            }
        }
        return counter;
    }
}
