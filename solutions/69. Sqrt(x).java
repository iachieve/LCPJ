class Solution {
    public int mySqrt(int x) {
      if(x <= 1) return x;
      int l = 1, h = x/2;
      while(l <= h){
        int m = l + (h-l) / 2;
        if(m == x/m && x % m == 0) return m;
        else if(m <= x/m) l = m+1;
        else h = m-1;
      }
      return h;
    }
}
