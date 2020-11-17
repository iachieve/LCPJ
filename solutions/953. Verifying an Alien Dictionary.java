class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 1; i < words.length; i++){
            if(!inOrder(words[i - 1], words[i], order)) return false;
        }
        return true;
    }
    private boolean inOrder(String word1, String word2, String order){
        for(int i = 0; i < word1.length() && i < word2.length(); i++){
            int idx1 = order.indexOf(word1.charAt(i));
            int idx2 = order.indexOf(word2.charAt(i));
            if(idx1 != idx2) return idx1 < idx2;
        }
        return word1.length() <= word2.length();
    }
}
