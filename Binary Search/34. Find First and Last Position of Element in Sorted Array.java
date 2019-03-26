class Solution {
    public int[] searchRange(int[] nums, int target) {
     
        int[] arr = new int[] {-1, -1};
        // only object can have null value
        // int does not have null value
        // (int == null) will throw error
        
        if (nums == null || nums.length == 0){
            return arr;
        }
        
        int left = 0, right = nums.length - 1;
        while (left + 1 < right){
            
            int mid = left + (right - left) / 2;    
            if (nums[mid] == target){
                right = mid;
            }
            if (nums[mid] < target){
                left = mid;
            }            
            if (nums[mid] > target){
                right = mid;
            }
        }
        
        if (nums[right] == target){
            arr[0] = right;
        }
        if (nums[left] == target){
            arr[0] = left;
        }
        
        // need to check if the target is found and return
        // otherwise will throw ArrayOutofBounds since left is -1
        if (arr[0] == -1){ return arr;}
        
        left = arr[0];
        right = nums.length - 1;
        while (left + 1 < right){
            
            int mid = left + (right - left) / 2;    
            if (nums[mid] == target){
                left = mid;
            }
            if (nums[mid] < target){
                left = mid;
            }            
            if (nums[mid] > target){
                right = mid;
            }
        }
        
        if (nums[left] == target){
            arr[1] = left;
        }
        if (nums[right] == target){
            arr[1] = right;
        }
        
        return arr;
    }
}
