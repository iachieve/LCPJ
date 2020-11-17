class Solution {
    public void sortColors(int[] nums) {
        // bubble sort
        // Runtime: 2 ms, faster than 9.27% of Java online submissions for Sort Colors.
        // Memory Usage: 37.7 MB, less than 33.18% of Java online submissions for Sort Colors.
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = 0; j < nums.length - 1 - i; j++){
        //         if(nums[j] >= nums[j+1]){
        //             int temp = nums[j];
        //             nums[j] = nums[j+1];
        //             nums[j+1] = temp;
        //         }
        //     }
        // }
        
        // insertion sort
        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
        // Memory Usage: 37.7 MB, less than 44.77% of Java online submissions for Sort Colors.
        // for(int i = 1; i < nums.length; i++){
        //     int k = nums[i];
        //     int j = i - 1;
        //     while(j >= 0 && k < nums[j]){
        //         int temp = nums[j+1];
        //         nums[j+1] = nums[j];
        //         nums[j] = temp;
        //         j--;
        //     }
        // }
        
        // selection sort
        // Runtime: 1 ms, faster than 9.27% of Java online submissions for Sort Colors.
        // Memory Usage: 37.9 MB, less than 17.57% of Java online submissions for Sort Colors.
        for(int i = 0; i < nums.length; i++){
            int minVal = nums[i];
            int minIdx = i;
            for(int j = i; j < nums.length; j++){
                if(nums[j] < minVal){
                    minVal = nums[j];
                    minIdx = j;
                }
            }
            if(minVal < nums[i]){
                int temp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = temp;
            }
        }
        
    }
}
​
​
​
​
​
​
​
​
​
​
​
​
​
​
​
