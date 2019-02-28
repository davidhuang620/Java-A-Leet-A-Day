/*

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
    
    //helper 
    // public int [] newArr(int [] nums, int left, int right){
    //     int [] returnArr = new int[right - left - 1];
    //     for(int i = 0; i < right-left+1; i++){
    //         returnArr[i] = nums[left];
    //         left ++;
    //     }
    //     return returnArr;
    // }
     
}
