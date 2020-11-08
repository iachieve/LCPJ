class Solution {
    public int hammingDistance(int x, int y) {
        int diff = 0;
        for(int i = 0; i < 32; i++){
            if(((x ^ y) & 1) == 1) diff++;
            x = x >> 1;
            y = y >> 1;
        }
        return diff;
    }
}
