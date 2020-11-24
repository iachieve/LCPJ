class Solution {
    private static final String[] MAPPING = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        exploreCombination(0, new StringBuilder(), digits, res);
        return res;
    }
    // naming partial or current goes
    private void exploreCombination(int pos, StringBuilder partial, String digits, List<String> res){
        if(pos == digits.length()){
            res.add(partial.toString());
            return;
        }
        String letters = MAPPING[digits.charAt(pos) - '0'];
        for(char c: letters.toCharArray()){
            exploreCombination(pos + 1, partial.append(c), digits, res);
            partial.deleteCharAt(partial.length()-1);
        }
    }
}
