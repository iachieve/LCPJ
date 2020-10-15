class Solution {
   public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean isNegative = (num < 0);
       num = (isNegative? (num * -1): num);
        while (num != 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }
        return (isNegative ? "-" : "") + sb.toString();
    }
}
