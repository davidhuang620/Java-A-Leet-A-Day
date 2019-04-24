/*


Observe the pattern
Follow up: use constant space


*/
// constant space




/*
o(n) space
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        int[] ans = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++){
            product *= nums[i];
            left[i] = product;
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            product *= nums[i];
            right[i] = product;
        }
        for (int i = 0; i < nums.length; i++){
            if (i == 0){
                ans[i] = right[i + 1];
                continue;
            }
            if (i == nums.length - 1){
                ans[i] = left[i - 1];
                continue;
            }
            ans[i] = right[i + 1] * left[i - 1];
        }
        return ans;
    }
}
