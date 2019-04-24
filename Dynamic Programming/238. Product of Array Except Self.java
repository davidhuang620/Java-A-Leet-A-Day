/*


Observe the pattern
Follow up: use constant space
There are index tricks with constant space, gotta be careful
Better to draw simple example to really understand
*/
// constant space

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        int[] ans = new int[nums.length];
        ans[0] = 1;
        // we add this in so that the first/last items are easier to deal with later
        for (int i = 1; i < nums.length; i++){
            ans[i] = ans[i-1] * nums[i - 1];
        }
        int product = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            // we multiply the product after assign the ans
            // so that the last item and first item can be add in
            ans[i] = ans[i] * product;
            product *= nums[i];
        }
        return ans;
    }
}


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
