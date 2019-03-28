/*
  Very tricky problem
  There are four situation need to consider 
  first use targetAtLeft to decide which side the target is on
  Then use where mid and target are relatively at, decide to move left or right
  Better to draw out the example
  Alternative way of doing this is using a binary search first to find the minimum index is at, 
  then search on the side the target is on
*/

class Solution {
    public int search(int[] nums, int target) {
    
        if (nums == null || nums.length == 0 ) {
            return -1;
        }
        
        int low = 0, up = nums.length - 1;
        boolean targetAtLeft = target >= nums[0] ? true : false;
        
        while (low + 1 < up){
            int mid = low + (up - low) / 2;
            
            if (targetAtLeft){
                if ( nums[0] <= nums[mid] && nums[mid] <= target){
                    low = mid;
                } else {
                    up = mid;
                }    
            } else {
                if (nums[0] > nums[mid] && nums[mid] >= target){
                    up = mid;
                } else {
                    low = mid;
                }
            } 
        }
        
        if (nums[low] == target) { return low;}
        if (nums[up] == target) { return up;}
        return -1;
        
    }
}
