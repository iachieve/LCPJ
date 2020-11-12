class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        //Runtime: 2 ms, faster than 94.57% of Java online submissions for Intersection of Two Arrays II.
// Memory Usage: 39.5 MB, less than 8.26% of Java online submissions for Intersection of Two Arrays II
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0;
        List<Integer> list = new ArrayList();
        while(p1 < nums1.length && p2 < nums2.length){
                if(nums1[p1] == nums2[p2]){
                    list.add(nums1[p1]);
                    p1++;
                    p2++;
                }else if(nums1[p1] < nums2[p2]){
                    p1++;
                }else if(nums1[p1] > nums2[p2]){
                    p2++;
                }
        }
        
         int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
        
        /*
        //Runtime: 2 ms, faster than 94.57% of Java online submissions for Intersection of Two Arrays II.
// Memory Usage: 39.4 MB, less than 8.26% of Java online submissions for Intersection of Two Arrays II.
        if(nums2.length < nums1.length) return intersect(nums2, nums1);
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums1) map.put(n, map.getOrDefault(n, 0) + 1);
        
        List<Integer> list = new ArrayList<>();
        for(int n: nums2){
            int count = map.getOrDefault(n, 0) ;
            if(count > 0){
                list.add(n);
                map.put(n, count-1);
            }
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
        */
    }
}
