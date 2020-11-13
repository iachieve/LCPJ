// Runtime: 2 ms, faster than 97.85% of Java online submissions for Valid Palindrome.
// Memory Usage: 39.1 MB, less than 73.18% of Java online submissions for Valid Palindrome.
 
class Solution {
    public boolean isPalindrome(String s) {
        if(s==null) return true;
        int i=0, j=s.length()-1;
        s = s.toLowerCase();
        while(i<j){
            while(!isDigitOrChar(s.charAt(i)) && i<j) i++;
            while(!isDigitOrChar(s.charAt(j)) && i<j) j--;
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;j--;   
        }
        return true;
    }
    boolean isDigitOrChar(char c){
        if( (c >= 'a' && c <='z') ||
            (c >= '0' && c <='9'))
            return true;
        return false;
    }
}


// Runtime: 33 ms, faster than 11.52% of Java online submissions for Valid Palindrome.
// Memory Usage: 40 MB, less than 27.67% of Java online submissions for Valid Palindrome.
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", " ")
            .replaceAll("\\W", "")
            .toLowerCase();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}
