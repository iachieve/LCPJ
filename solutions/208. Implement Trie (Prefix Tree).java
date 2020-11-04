class Trie {
​
    private Node root;
    public Trie() {↔}
    
    public void insert(String word) {
        Node curr = root;
        for(char c :word.toCharArray()){
            if(curr.children[c-'a'] == null) curr.children[c-'a'] = new Node(c);
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }
    
    private Node getNode(String word){
        Node curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null) return null;
            curr = curr.children[c - 'a'];
        }
        return curr;
    }
    
    class Node{
        public char c;
        public boolean isWord;
        public Node[] children;
        public Node(char c){
            this.c = c;
            this.isWord = false;
            this.children = new Node[26];
        }
    }    
}
​
