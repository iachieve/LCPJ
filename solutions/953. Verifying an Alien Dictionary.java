class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charMap = new int[26];
        for(int i = 0; i < order.length(); i++) charMap[order.charAt(i) - 'a'] = i;
        for(int i = 1; i < words.length; i++){
            if(compare(words[i-1], words[i], charMap) > 0) return false;
        }
        return true;
    }
    private int compare(String word1, String word2, int[] charMap){
        int i = 0, j = 0, res = 0;
        while(i < word1.length() && j < word2.length() && res == 0){
            res = charMap[word1.charAt(i) - 'a'] - charMap[word2.charAt(j)-'a'];
            i++;
            j++;
        }
        if(res == 0){
            return word1.length() - word2.length();
        }else{
            return res;
        }
    }
}
