class Solution {
 // TC: O(NK log K)
 // SC: O(N K)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            anagrams.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);

            // List<String> anagramList = anagrams.getOrDefault(sortedWord, new ArrayList<String>());
            // anagramList.add(word);            
            // anagrams.put(sortedWord, anagramList);
        }
        return new ArrayList<>(anagrams.values());
    }
}
​
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         if (strs.length == 0) return new ArrayList();
//         Map<String, List> ans = new HashMap<String, List>();
//         int[] count = new int[26];
//         for (String s : strs) {
//             Arrays.fill(count, 0);
//             for (char c : s.toCharArray()) count[c - 'a']++;
​
//             StringBuilder sb = new StringBuilder("");
//             for (int i = 0; i < 26; i++) {
//                 sb.append('#');
//                 sb.append(count[i]);
//             }
//             String key = sb.toString();
//             if (!ans.containsKey(key)) ans.put(key, new ArrayList());
//             ans.get(key).add(s);
//         }
//         return new ArrayList(ans.values());
//     }
// }
