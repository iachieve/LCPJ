public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int times = 32, res = 0;
        List<Integer> l = new ArrayList();
        while(times > 0){
            int t = n & 1;
            l.add(0, t);
            n >>= 1;
            times--;
        }
        
        for(int i = l.size() - 1; i >= 0; i--){
            res <<= 1;
            res = res | l.get(i);
        }
        return res;
    }
}
