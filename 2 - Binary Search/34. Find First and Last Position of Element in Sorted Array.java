        // only object can have null value
        // int does not have null value
        // (int == null) will throw error
 


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        
        int[] ans = new int[2];
        ans[0] = helper(nums, target, true);
        ans[1] = helper(nums, target, false);
        return ans;
        
    }
    
    private int helper(int[] nums, int target, boolean first){
        
        int low = 0, up = nums.length - 1;
        while(low + 1 < up){
            int mid = low + (up - low) / 2;
            
            if (nums[mid] == target && first){
                up = mid;
            } else if (nums[mid] == target && !first){
                low = mid;
            } else if (nums[mid] > target){
                up = mid;
            } else {
                low = mid;
            }
        }
        
        if (first){
            if (nums[low] == target) return low;
            if (nums[up] == target) return up;
            return -1;
        } 
        
        if (nums[up] == target) return up;
        if (nums[low] == target) return low;
        return -1;
            
    }
    
}
