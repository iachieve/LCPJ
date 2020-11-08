class Solution {
    public int hammingDistance(int x, int y) {
        // solution 1
        // int diff = 0;
        // for(int i = 0; i < 32; i++){
        //     if(((x ^ y) & 1) == 1) diff++;
        //     x = x >> 1;
        //     y = y >> 1;
        // }
        // return diff;
        
        // solution 2
        int dif = 0;
        while(x != 0 || y != 0){
            // x % 2 return LSB
            dif += (x % 2) ^ (y % 2);
            x >>= 1; // equivalent to dividing by 2
            y >>= 1;
        }
        return dif;
    }
}
