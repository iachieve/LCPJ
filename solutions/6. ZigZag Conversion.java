class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        boolean down = false;
        int row = 0;
        
        List<StringBuilder> output = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            output.add(new StringBuilder());
        
​
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
