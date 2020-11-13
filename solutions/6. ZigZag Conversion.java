class Solution {
    public String convert(String s, int numRows) {
        
        
//         // Runtime: 2 ms, faster than 99.88% of Java online submissions for ZigZag Conversion.
// // Memory Usage: 39.3 MB, less than 81.98% of Java online submissions for ZigZag Conversion.
//         if (numRows == 1) return s;

//         StringBuilder ret = new StringBuilder();
//         int n = s.length();
//         int cycleLen = 2 * numRows - 2;

//         for (int i = 0; i < numRows; i++) {
//             for (int j = 0; j + i < n; j += cycleLen) {
//                 ret.append(s.charAt(j + i));
//                 if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
//                     ret.append(s.charAt(j + cycleLen - i));
//             }
//         }
//         return ret.toString();
        
        
//         // Runtime: 5 ms, faster than 73.47% of Java online submissions for ZigZag Conversion.
//         // Memory Usage: 40 MB, less than 28.41% of Java online submissions for ZigZag Conversion.
        if(numRows == 1) return s;
        boolean down = false;
        int row = 0;
        
        List<StringBuilder> output = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            output.add(new StringBuilder());
        

        for(char c : s.toCharArray()){
            output.get(row).append(c);
            if((row == 0) || (row == numRows - 1)) down = !down;
            row += down ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder st: output) sb.append(st);
        return sb.toString();
    }
}
