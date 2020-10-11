class Solution {
    public int binaryGap(int N) {
         String s = Integer.toBinaryString(N);
        int pre = 0, result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                result = Math.max(result, i - pre);
                pre = i;
            }
        }
        return result;
    }
}
