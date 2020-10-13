class Solution {
​
    public int toMinutes(String time){
        return (Integer.parseInt(time.substring(0, 2)) * 60) 
            + Integer.parseInt(time.substring(3, 5));
    }
    public int findMinDifference(List<String> timePoints) {
        boolean[] seen = new boolean[1440];
        int prev = -1;
        int minDiff = 1441;
        int first = -1;
        for(String time: timePoints){
            int min = toMinutes(time);
            if(seen[min]) return 0;
            seen[min] = true;
        }
        for(int i = 0; i < 1440; i++){
            if(seen[i]){
                if(prev != -1){
                    minDiff = Math.min(minDiff, (i - prev));
            }else{
                first = i;
            }
            prev = i;
            }
         
        }
        return Math.min(minDiff, (first + 1440 - prev));
    }
}
