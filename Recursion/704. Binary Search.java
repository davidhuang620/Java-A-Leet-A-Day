/*


Do I have to pass in nums, and target ? 
Yes, because inner scope do not have access to variables from outer scope.
Contrast to JavaScript where inner scope do have access to outer scope, and it is called closure.

*/

// Recursion on the original function

class Solution {
    public int search(int[] nums, int target) {
        
        if(nums.length == 0) { return -1; }
        
        int midIndex = nums.length/2;
        int mid = nums[midIndex];
        
        if(mid == target){
            return midIndex;
        }
        
        if(nums.length == 1) {
            return -1;
        }
        
        if(mid > target){
            int [] arr = Arrays.copyOfRange(nums, 0, midIndex);
            return search(arr, target);
        }else{
            int [] arr = Arrays.copyOfRange(nums, midIndex+1, nums.length);
            return midIndex + search(arr, target);
        }
    }
     
}


// Recursion on a separated function.
class Solution {
    
    public int search(int[] nums, int target) {
        

        return binarySearch(nums, 0, nums.length-1, target);
    }
    
    private int binarySearch(int[] nums, int start, int end, int target){
        
        int mid = (start + end)/2;
        
        if(nums[mid] == target){
            return mid;
        }
        
        if(start >= end){
            return -1;
        }
        
        if(nums[mid] > target){
            return binarySearch(nums, start, mid-1, target);
        }
        if(nums[mid] < target){
            return binarySearch(nums, mid+1, end, target);
        }
        
        return -1;
    }
    
    
}


// Iterative

class Solution {
    
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            
            int mid = (start + end)/2;
            
            if (nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return -1;
    }
}

