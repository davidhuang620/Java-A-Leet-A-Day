class Solution {
    public int findMin(int[] nums) {
        
        // Validation 
        if (nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }
        
        // Is each element unique ?
        // Does it has to be rotated ? Does a sorted array count ?
        
        int low = 0, up = nums.length - 1;
        
        if (nums[low] < nums[up]){
            return nums[low];
        }
        
        while (low + 1 < up){
            
            int mid = low + (up - low) / 2;
            if (nums[mid] > nums[low]){
                low = mid;
            } else {
                up = mid;
            }
        }
        
        return nums[up];
        
    }
}
