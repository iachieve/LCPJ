class Solution {
        /*
     * Steps:
     * 1- create array list to store valid subsets
     * 2- create array (bCount) carry all characters frequencies from list B COMBINED
     * 2- iterate over list B and for every word get the frequency array
     *      using the helper method.
     *      -> AND update bCount array
     * 3- iterate over list A word by word
     *      -> get array (tempCount) of frequencies
     *      -> compare indexes values between tempCount and bCount
     *      -> if the value in tempCount is < the value in bCount, it not universal 
     * 4- check after the comparison, if the word is universal, add it to the return subsets array
     * 
     * */
        public List<String> wordSubsets(String[] A, String[] B) {
        List<String> subsets = new ArrayList<>();
        int[] bCount = new int[26];
        for(String word : B){
            int[] temp = count(word);
            for(int i = 0; i < 26; i++) bCount[i] = Math.max(bCount[i], temp[i]);
        }
        
        for(String word: A){
            int[] temp = count(word);
            boolean isUniversal = true;
            for(int i = 0; i < 26; i++)
                if(temp[i] < bCount[i]){
                    isUniversal = false;
                    break;
                }
            if(isUniversal) subsets.add(word);
        }
        
        return subsets;
    }
​
    // return array of character frequencies for a word
    private int[] count(String word){
        int[] output = new int[26];
        for(char c : word.toCharArray()) output[c-'a'] += 1;
        return output;
    }
}
