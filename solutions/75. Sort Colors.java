class Solution {
    private void swap(int idx1, int idx2, int[] nums){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    public void sortColors(int[] nums) {
        // bubble sort
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = 0; j < nums.length - 1 - i; j++){
        //         if(nums[j] > nums[j+1]) swap(j, j + 1, nums);
        //     }
        // }
        
        // insertion sort
        // for(int i = 1; i < nums.length; i++){
        //     int k = nums[i];
        //     int j = i - 1;
        //     while(j >= 0 && k < nums[j]){
        //         swap(j, j+1, nums);
        //         j--;
        //     }
        // }
        
        // selection sort
        // for(int i = 0; i < nums.length; i++){
        //     int minVal = nums[i];
        //     int minIdx = i;
        //     for(int j = i ; j < nums.length; j++){
        //         if(nums[j] < minVal){
        //             minIdx = j;
        //             minVal = nums[j];
        //         }
        //     }
        //     if(minVal < nums[i]){
        //         swap(minIdx, i, nums);
        //     }
        // }
        
        // merge Sort
        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
        // Memory Usage: 38 MB, less than 13.47% of Java online submissions for Sort Colors.
        mergeSort(nums);
    }
    private void mergeSort (int[] nums) {
        int len = nums.length;
        if(len < 2) return;
        int mid = len / 2;
        // int[] left = new int[mid];
        // int[] right = new int[len - mid];
        // for(int i = 0; i < mid; i++) left[i] = nums[i];
        // for(int i = mid; i < len; i++) right[i - mid] = nums[i];
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, len);
        mergeSort(left);
        mergeSort(right);
        merge(nums, left, right);
    }
    
    private void merge(int[] nums, int[] left, int[] right){
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length) nums[k++] = left[i] <= right[j] ? left[i++]: right[j++];
        while(i < left.length) nums[k++] = left[i++];
        while(j < right.length) nums[k++] = right[j++];
    }

    
}



// Heap Sort
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
// Memory Usage: 37.8 MB, less than 29.58% of Java online submissions for Sort Colors.
    
class Solution {
    public void sortColors(int[] nums) {
        buildMaxHeap(nums);
        for(int endIdx = nums.length - 1; endIdx >= 0; endIdx--){
            swap(0, endIdx, nums);
            siftDown(0, endIdx - 1, nums);
        }
    }
    
    private void buildMaxHeap(int[] nums){
        int firstParentIdx = (nums.length - 2) / 2;
        for(int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--){
            siftDown(currentIdx, nums.length - 1, nums);
        }
    }
    
    private void siftDown(int currentIdx, int endIdx, int[] nums){
        int firstChildIdx = currentIdx * 2 + 1;
        while(firstChildIdx <= endIdx){
            int secondChildIdx = currentIdx*2+2 <= endIdx ? currentIdx*2+2 : -1;
            int idxToSwap;
            if(secondChildIdx != -1 && nums[secondChildIdx] > nums[firstChildIdx]){
                idxToSwap = secondChildIdx;
            }else{
                idxToSwap = firstChildIdx;
            }
            
            if(nums[idxToSwap] > nums[currentIdx]){
                swap(idxToSwap, currentIdx, nums);
                currentIdx = idxToSwap;
                firstChildIdx = currentIdx * 2 + 1;
            }else{
                return;
            }
            
        }
    }
    
    
    
        
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}









