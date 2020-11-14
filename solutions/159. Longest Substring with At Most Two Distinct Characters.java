class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if(len < 3) return len;
        int left = 0, right = 0, max = 2;
        Map<Character, Integer> map = new HashMap<>();
        while(right < len){
            map.put(s.charAt(right), right++);
            if(map.size() == 3){
                int delIdx = Collections.min(map.values());
                map.remove(s.charAt(delIdx));
                left = delIdx + 1;
            }
        max = Math.max(max, right - left);
        }
        return max;
    }
}
​
/*
    eceba
    left ->  0, right -> 0
    map => {e=0}, size: 1
    max length: 2
    left ->  0, right -> 1
    map => {c=1, e=0}, size: 2
    max length: 2
    left ->  0, right -> 2
    map => {c=1, e=2}, size: 2
    max length: 3
    left ->  0, right -> 3
    map => {b=3, c=1, e=2}, size: 3
    deleting index: 1
    map => {b=3, e=2}size: 2
    max length: 3
    left ->  2, right -> 4
    map => {a=4, b=3, e=2}, size: 3
    deleting index: 2
    map => {a=4, b=3}size: 2
    max length: 3
​
*/
