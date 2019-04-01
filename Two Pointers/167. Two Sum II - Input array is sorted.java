// Since it is sorted, we can use two pointers, one at low, one at up
// we won't miss any potential answer when scanning 

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        if (nums == null || nums.length <= 1){
            return null;
        }
        
        int[] ans = new int[2];
        int low = 0, up = nums.length - 1;
        
        while (low < up){
            if (nums[low] + nums[up] == target){
                ans[0] = low + 1;
                ans[1] = up + 1;
                return ans;
            } else if (nums[low] + nums[up] > target){
                up--;
            } else {
                low++;
            }
        }
        
        return ans;
        
    }
}
