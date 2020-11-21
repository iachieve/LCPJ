class Solution {
    private static final String[] MAPPING = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }
    
    private void backtrack(String digits, int idx, StringBuilder combination, List<String> res){
        if(idx == digits.length()){
            res.add(combination.toString());
            return;
        }
        
        String letters = MAPPING[digits.charAt(idx) - '0'];
        for(char letter: letters.toCharArray()){
            backtrack(digits, idx + 1, combination.append(letter), res);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
