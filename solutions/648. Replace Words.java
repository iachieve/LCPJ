class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Map<String, Boolean> prefixes = new HashMap<>();
        for(String dic : dictionary) prefixes.put(dic, true);
        
        for(int wi = 0; wi < words.length; wi++){
            String word = words[wi];
            for(int i = 0; i < word.length(); i++){
                String part = word.substring(0, i);
                if(prefixes.get(part) != null){
                    words[wi] = part;
                    break;
                }
            }
        }
        return String.join(" ", words);
    }
}


class Solution {
    static class TrieNode {
        TrieNode[] next;
        boolean isWord;
        String word;
        TrieNode() {
            this.next = new TrieNode[26];
            this.isWord = false;
        }
    }
    static class Trie {
        TrieNode root;
        Trie() {
            this.root = new TrieNode();
        }
        public void addWord(String word) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                if (cur.next[ch-'a'] == null) cur.next[ch-'a'] = new TrieNode();
                cur = cur.next[ch-'a'];
            }
            cur.isWord = true;
            cur.word = word;
        }
    }
    public String findPrefix(Trie trie, String word) {
        TrieNode cur = trie.root;
        for (char ch : word.toCharArray()) {
            if (cur.isWord) return cur.word; // to return the shortest prefix
            if (cur.next[ch-'a'] == null) return ""; // no prefix possible
            cur = cur.next[ch-'a'];
        }
        return ""; //traversed the entire word but no prefix was found 
		//(essentially the word became the prefix of the word in the dictionary)
    }
    public String replaceWords(List<String> dict, String sentence) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        String[] words = sentence.split(" ");
        for (String word : dict) trie.addWord(word);
        for (String word : words) {
            String res = findPrefix(trie, word);
            if (res.length() == 0) result.add(word);
            else result.add(res);
        }
        return String.join(" ", result);
    }
}
