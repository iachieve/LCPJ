class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuffer sb = new StringBuffer("");
        int carry = 0;
        while(i >= 0 || j >=0){
            int sum = carry;
            if(i >= 0){
                sum += num1.charAt(i) - '0';
                i--;
            }
            
            if(j >= 0){
                sum += num2.charAt(j) - '0';
                j--;
            }
            
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        
        if(carry != 0) sb.insert(0, carry);
        return sb.toString();
    }
}
