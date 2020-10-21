class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
          /*
            1- the sequence should be decremented from the last position to the first position
            2- walk backwards and find the number that is less than the current number
            Ex: input = {6,2,1,5,4,3,0}
            0 < 3   | 3 < 4 | 4 < 5 | 5 !< 1
            first number we need to swap is 1
         */
        
        while(i >= 0 && nums[i+1] <= nums[i]) i--;
        if(i >= 0){
            int j = nums.length - 1;
             /*
                previous debug:
                    Ex: input = {6,2,1,5,4,3,0}
                    0 < 3   | 3 < 4 | 4 < 5 | 5 !< 1
                    first number we need to swap is 1
​
                Next:
                we got the first number to swap which is 1
                now walk backwards and look for the first greater number than 1
                Ex: input = {6,2,(1),5,4,3,0}
                0 !> 1  |   3 is greater than 1
                swap 3 & a
                   {6, 2, 3, 5, 4, 1, 0}
            */
            while(j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
           /*
            reverse element order starting from i+1 to be decremented again from last element
            ex: {6, 2, 3, (5), 4, 1, (0)}
                {6, 2, 3, 0, (4), (1), 5}
                {6, 2, 3, 0, 1, 4, 5} => answer
         */
        reverse(nums, i + 1);        
    }
    
    private void reverse(int[] nums, int start){
        int left = start;
        int right = nums.length - 1;
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
