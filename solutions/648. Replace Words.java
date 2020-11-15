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

Runtime: 5 ms, faster than 99.90% of Java online submissions for Replace Words.
Memory Usage: 50.9 MB, less than 42.47% of Java online submissions for Replace Words.
class Solution {
    /*
    Main idea is split given sentence into words. 
        Now for each word find if we can find a word in Trie tree with prefix string of any length otherwise just return original string.
    See below comments further.
    */
    public String replaceWords(List<String> dictionary, String sentence) 
    {
        root = new Trie();
        for(String word:dictionary)
            add(root,word);
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++)
        {
            String sub = find(root,words[i]);
            if(i!=0)
                sb.append(" ");
            sb.append(sub);
        }
        return sb.toString();
    }
    
    String find(Trie node, String originalWord)
    {
        for(int i=0;i<originalWord.length();i++)
        {
            char ch = originalWord.charAt(i);
            int j = ch - 'a';
            if(node!=null && node.isWord)//We got prefix string as a word in dictionary then return it.
                return node.word;
            if(node.childs[j] != null)
                node = node.childs[j];
            else
                break;//we don't see any further words in dictionary, and the prefix stirng originalWord.substring(0,j+1) is not dictionary word. so break it. return original word.
        }
        return originalWord;//If we could not find prefix word from dictionary, then return original word.
    }
    
    Trie root;
    class Trie
    {
        Trie[] childs;
        boolean isWord;
        String word;
        
        Trie(){
            childs = new Trie[26];
        }
    }
    //Trie tree construction with dictionary words.
    void add(Trie root, String word)
    {
        Trie curr = root;
        for(char c:word.toCharArray())
        {
            int i = c - 'a';
            if(curr.childs[i]==null)
                curr.childs[i] = new Trie();
            curr = curr.childs[i];
        }
        curr.isWord=true;
        curr.word = word;
    }
}


// more concise
class Solution {
    class Trie{
        Trie[] children = new Trie[26];
        boolean isWord;
        String word;
    }
    
    void add(Trie root, String word){
        for(char c: word.toCharArray()){
            int i = c - 'a';
            if(root.children[i] == null) root.children[i] = new Trie();
            root = root.children[i];
        }
        root.isWord = true;
        root.word = word;
    }
    
    String find(Trie root, String orgWord){
        for(char c: orgWord.toCharArray()){
            int i = c - 'a';
            if(root != null && root.isWord) return root.word;
            else if(root.children[i] != null) root = root.children[i];
            else break;
        }
        return orgWord;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for(String word: dictionary) add(root, word);
        StringBuilder ans = new StringBuilder();
        for(String word: sentence.split(" ")){
            ans.append(" " + find(root, word));
        }
        return ans.toString().trim();
    }
}
