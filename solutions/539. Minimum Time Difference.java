class Solution {
    private int toMin(String time){
        return (Integer.parseInt(time.substring(0, 2)) * 60) + 
            Integer.parseInt(time.substring(3, 5));
    }
    public int findMinDifference(List<String> timePoints) {
        int first = -1;
        int prev = -1;
        int minDiff = 1441;
        boolean[] seen = new boolean[1440];
        
        for(String time: timePoints){
            int n = toMin(time);
            if(seen[n]) return 0;
            seen[n] = true;
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
        
        minDiff = Math.min(minDiff, (1440 + first - prev));
        return minDiff;
    }
}
