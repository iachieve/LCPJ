class Solution {
    public boolean isPalindrome(String str) {
        
        str = str.replaceAll("[^a-zA-Z0-9]", " ");  
        str = str.replaceAll("\\W", "");
        String reversed = "";
 
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }
        System.out.println(str);
        System.out.println(reversed);
​
        
        return str.toLowerCase().equals(reversed.toLowerCase());
    }
}
