class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Word Pattern.
    // Memory Usage: 37 MB, less than 10.21% of Java online submissions for Word Pattern.
    public boolean wordPattern(String patternString, String sentence) {
        Map<Character, String> patternToWord = new HashMap<>();
        Map<String, Character> wordToPattern = new HashMap<>();
        
        String[] words = sentence.split(" ");
        if(words.length != patternString.length()) return false;
        
        for(int i = 0; i < words.length; i++){
            char patternChar = patternString.charAt(i);
            String word = words[i];
            
            if(!patternToWord.containsKey(patternChar))
                patternToWord.put(patternChar, word);
            if(!wordToPattern.containsKey(word))
                wordToPattern.put(word, patternChar);
            
            if(!patternToWord.get(patternChar).equals(word)
              || wordToPattern.get(word) != patternChar
              ) return false;
        }
        return true;
    }
}
// 1
