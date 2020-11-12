class Solution {
    
    private boolean find(int num, int[] arr){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == num) return true;
            else if(num <= arr[mid]) right = mid - 1;
            else if(num > arr[mid])left = mid+1;
        }
        return false;
    }
    
    
    public int[] intersection(int[] nums1, int[] nums2) {
        
        /*
        // Runtime: 3 ms, faster than 36.13% of Java online submissions for Intersection of Two Arrays.
// Memory Usage: 39.5 MB, less than 9.32% of Java online submissions for Intersection of Two Arrays.
    
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0;
        Set<Integer> intersect = new HashSet<>();
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                intersect.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1] < nums2[p2]){
                p1++;
            }else if(nums1[p1] > nums2[p2]){
                p2++;
            }
        }
        
         int i = 0;
        int[] result = new int[intersect.size()];
        for(int num: intersect){
            result[i] = num;
            i++;
        }
        return result; 
        */
        
        
        /*
// Runtime: 3 ms, faster than 36.13% of Java online submissions for Intersection of Two Arrays.
// Memory Usage: 39.3 MB, less than 9.32% of Java online submissions for Intersection of Two Arrays.
    
        Arrays.sort(nums1);
        HashSet<Integer> itersect = new HashSet<>();
        
        for(int num: nums2){
            if(find(num, nums1)){
                itersect.add(num);
            }
        }
        
        int i = 0;
         int[] result = new int[itersect.size()];
        for(int num: itersect){
            result[i] = num;
            i++;
        }
        
        return result;
        */
        
        
        
        //Runtime: 2 ms, faster than 98.26% of Java online submissions for Intersection of Two Arrays.
// Memory Usage: 39.4 MB, less than 9.32% of Java online submissions for Intersection of Two Arrays.
        Set<Integer> set1 = new HashSet<>();
        for(int num: nums1) set1.add(num);
        
        Set<Integer> intersect = new HashSet<>();
        for(int num: nums2){
            if(set1.contains(num)) intersect.add(num);
        }
        int i = 0;
        int[] result = new int[intersect.size()];
        for(int num: intersect){
            result[i] = num;
            i++;
        }
        return result; 
        
        
        /*
        time: O(n+m) on average
        worst case: O(n*m)
        space: O(n+m) => two hashsets
        
        // Runtime: 2 ms, faster than 98.26% of Java online submissions for Intersection of Two Arrays.
// Memory Usage: 39 MB, less than 9.32% of Java online submissions for Intersection of Two Arrays.
        Set<Integer> set1 = new HashSet<>();
        for(int num: nums1) set1.add(num);
        
        Set<Integer> set2 = new HashSet<>();
        for(int num: nums2) set2.add(num);
        
        set1.retainAll(set2);
        
        int[] result = new int[set1.size()];
        int i = 0;
        for(int num: set1){
            result[i] = num;
            i++;
        }
        return result;
        */
        
    }
}
