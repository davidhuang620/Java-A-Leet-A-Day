



class Solution {
    public int findPeakElement(int[] nums) {
        
        if (nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }
        
        // binary search consider 2 cases 
        // so always check the edge case where array length == 1
        
        if (nums.length == 1){
            return 0;
        }
        
        int low = 0, up = nums.length - 1;
        while( low + 1 < up){
            
            int mid = low + (up - low) / 2;
           if (nums[mid] > nums[mid + 1] ){
                up = mid;
            } else {
                low = mid;
            }
        }
        
        return nums[low] > nums[up] ? low : up;
    }
    
}




// long version

class Solution {
    public int findPeakElement(int[] nums) {
        
        if (nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }
        
        // binary search consider 2 cases 
        // so always check the edge case where array length == 1
        
        if (nums.length == 1){
            return 0;
        }
        
        int low = 0, up = nums.length - 1;
        while( low + 1 < up){
            
            int mid = low + (up - low) / 2;
            if (isPeak(nums, mid)){
                return mid;    
            } 
            // since mid is left sided (cuz the java int trump)
            // so we don't need to worry about nums[mid + 1] > nums.length - 1
            else if (nums[mid] > nums[mid + 1] ){
                up = mid;
            } else {
                low = mid;
            }
        }
        
        return isPeak(nums, low) ? low : up;
        
    }
    
    private boolean isPeak(int[] nums, int index){
        if (index == 0){
            return nums[0] > nums[1] ? true : false;
        } 
        if (index == nums.length - 1){
            return nums[index] > nums[index - 1] ? true : false;
        }
        
        return nums[index] > nums[index + 1] && nums[index] > nums[index - 1] ? true : false;
    }
    
}
