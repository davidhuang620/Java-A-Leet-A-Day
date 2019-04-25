class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if (nums == null || nums.length == 0){
            return -1;
        }
        
        // Kth Largest = the (nums.length - k) index in the array 
        k = nums.length - k;
        quickSelect(nums, 0, nums.length - 1, k);
        return nums[k];
    }    
    
    private void quickSelect(int[] nums, int start, int end, int k){
        
        if (start >= end){
            return;
        }
        
        int low = start, up = end, pivot = nums[(start + end) / 2];
        while (low <= up){
            while (low <= up && nums[low] < pivot){
                low++;
            }
            while (low <= up && nums[up] > pivot){
                up--;
            }
            if (low <= up){
                int temp = nums[low];
                nums[low] = nums[up];
                nums[up] = temp;
                low++;
                up--;
            }
        }
        
        if (up >= k ){
            quickSelect(nums, start, up, k);
        }
        if (low <= k){
            quickSelect(nums, low, end, k);
        }
        
    }
    
}
