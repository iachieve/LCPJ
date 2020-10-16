class Solution {
    public String convert(String s, int numRows) {
        List<String> output = new ArrayList<>(Collections.nCopies(numRows + 1, ""));
        boolean down = false;
        int row = 0;
        for(char c: s.toCharArray()){
            output.set(row, output.get(row) + c );
            if((row == 0) || (row == numRows - 1)) down = !down;
            if(numRows > 1){
                if(down) row++;
                    else row--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String st: output) sb.append(st);
        return sb.toString();
    }
}
