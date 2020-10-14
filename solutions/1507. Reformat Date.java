class Solution {
      private static final Map<String, String> months = getMonths();
​
    public String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        String[] items = date.trim().split("\\s+");
        String day = items[0].substring(0, items[0].length() - 2);
        if(day.length() != 2) day = "0" + day;
        String month = months.get(items[1]);
        sb.append(items[2]).append("-").append(month).append("-").append(day);
        return sb.toString();
    }
    
    
    private static Map<String, String> getMonths() {
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        return months;
  }
}
