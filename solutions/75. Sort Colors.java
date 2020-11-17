        //         swap(j, j+1, nums);
        //         j--;
        //     }
        // }
        
        // selection sort
        // for(int i = 0; i < nums.length; i++){
        //     int minVal = nums[i];
        //     int minIdx = i;
        //     for(int j = i ; j < nums.length; j++){
        //         if(nums[j] < minVal){
        //             minIdx = j;
        //             minVal = nums[j];
        //         }
        //     }
        //     if(minVal < nums[i]){
        //         swap(minIdx, i, nums);
        //     }
        // }
        
        // merge Sort
        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
        // Memory Usage: 38 MB, less than 13.47% of Java online submissions for Sort Colors.
        mergeSort(nums);
    }
    private void mergeSort (int[] nums) {
        int len = nums.length, mid = len / 2;
         if (len < 2) { return; }
        int[] left = new int[mid], right = new int[len - mid];
        for(int i = 0; i < mid; i++) left[i] = nums[i];
        for(int i = mid; i < len; i++) right[i - mid] = nums[i];
        mergeSort(left);
        mergeSort(right);
        merge(nums, left, right);
    }
    
    private void merge (int[] nums, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]) nums[k++] = left[i++];
            else nums[k++] = right[j++];
        }
        while(i < left.length) nums[k++] = left[i++];
        while(j < right.length) nums[k++] = right[j++];
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
​
​
​
​
​
​
