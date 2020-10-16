class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> wordToPattern = new HashMap<>();
        Map<Character, String> patternToWord = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        for (int i = 0; i < words.length; i++) {
            char patternChar = pattern.charAt(i);
            if (!wordToPattern.containsKey(words[i])) wordToPattern.put(words[i], patternChar);
            if (!patternToWord.containsKey(pattern.charAt(i))) patternToWord.put(patternChar, words[i]);
            if (wordToPattern.get(words[i]) != patternChar ||
                    !patternToWord.get(pattern.charAt(i)).equals(words[i]))
                return false;
        }
        return true;
    }
}
