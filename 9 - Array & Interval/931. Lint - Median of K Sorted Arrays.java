/*

A bit too length and hard

*/

public class Solution {

    public double findMedian(int[][] nums) {
        
        int count = 0;
        for (int[] list : nums){
            if (list != null && list.length != 0){
                count += list.length;
            }
        }
        
        if (nums == null || nums.length == 0 || count == 0){
            return 0; 
        }
        
        // prevent overflow
        if (count % 2 == 0){
            return findKth(nums, count/2) / 2.0
            + findKth(nums, count/2 + 1) / 2.0;
        }
    
        return findKth(nums, count/2 + 1);
    
    }
    
    private int findKth(int[][] nums, int k){
        
        int max = Integer.MIN_VALUE;
        for (int[] list : nums){
            if (list != null && list.length != 0){
                max = Math.max(max, list[list.length - 1]);
            }
        }
        
        int low = 0, up = max;
        while (low + 1 < up){
            int mid = low + (up - low) / 2;
            if (countLessThan(nums, mid) >= k){
                up = mid;
            } else {
                low = mid;
            }
        }

        if (countLessThan(nums, low) >= k ) return low;
        return up;
        
    }
    
    private int countLessThan(int[][] nums, int target){
        
        int count = 0;
        for (int[] list : nums){
             count += countLessThan(list, target);
        }
        return count;
    }
    
    private int countLessThan(int[] nums, int target){
        
        if (nums == null || nums.length == 0) return 0;
        
        int low = 0, up = nums.length - 1;
        while (low + 1 < up){ 
            int mid = (low + up) / 2;
            if (nums[mid] <= target){
                low = mid;
            } else {
                up = mid;
            }
        }
        
        // returning the count, not index
        if (nums[up] <= target){
            return up + 1;
        }
        
        if (nums[low] <= target){
            return low + 1;
        }
        
        return 0;
    }
    
}
