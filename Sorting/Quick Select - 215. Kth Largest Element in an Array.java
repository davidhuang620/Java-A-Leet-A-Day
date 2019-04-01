class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return -1;
        }   
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k){
        
        if (start == end){
            return nums[start];
        }
        
        int pivot = nums[(start + end) / 2];
        int low = start, up = end;
        
        // sort array from large to small
        
        while (low <= up){
            while (low <= up && nums[low] > pivot){
                low++;
            }
            while (low <= up && nums[up] < pivot){
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
    
        // Be Careful with the boundary here
        
        if (up - start + 1 >= k){
            return quickSelect(nums, start, up, k);
        }
        if (low - start + 1 <= k){
            return quickSelect(nums, low, end, k - (low - start));
        }
        
        return nums[up + 1];
        
    } 
    
}
