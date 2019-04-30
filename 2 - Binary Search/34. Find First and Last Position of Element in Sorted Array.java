        // only object can have null value
        // int does not have null value
        // (int == null) will throw error
 
class Solution {
    public int[] searchRange(int[] nums, int target) {
     
        int[] arr = new int[] {-1, -1};
        
        if (nums == null || nums.length == 0){
            return arr;
        }
        
        findLeft(nums, target, arr);
        findRight(nums, target, arr);
        
        return arr;
    }
    
    private void findLeft (int[] nums, int target, int[] arr){

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
            
     }
        
    private void findRight (int[] nums, int target, int[] arr){

        int left = 0, right = nums.length - 1;
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
    }
}
