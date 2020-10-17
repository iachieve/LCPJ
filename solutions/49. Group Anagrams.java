class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            anagrams.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
​
            // List<String> anagramList = anagrams.getOrDefault(sortedWord, new ArrayList<String>());
            // anagramList.add(word);            
            // anagrams.put(sortedWord, anagramList);
        }
        return new ArrayList<>(anagrams.values());
    }
}
