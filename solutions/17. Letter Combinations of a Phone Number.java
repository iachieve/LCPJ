class Solution {
    private static final String[] MAPPING = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
  public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        exploreCombinations(0, new StringBuilder(), digits, res);
        return res;
    }
    
    private void exploreCombinations(int currIdx, StringBuilder partial, String digits, List<String> res) {
        if (currIdx == digits.length()) {
            res.add(partial.toString());
            return;
        }
​
        String letters = MAPPING[digits.charAt(currIdx) - '0'];
​
        for (char possibleLetter: letters.toCharArray()) {
            // 1.) Choose - Append the letter that this digit can materialize into
            partial.append(possibleLetter);
​
            // 2.) Explore - Recurse on the decision with changed state. We advance the digit we are working on.
            exploreCombinations(currIdx + 1, partial, digits, res);
​
            // 3.) Unchoose - We have returned to this stack frame of choice. Remove the choice, next loop will choose again.
            partial.deleteCharAt(partial.length() - 1);
        }
    }
​
}
