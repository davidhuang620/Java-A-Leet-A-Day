/*

This problem is similar to Max Subarray
but the product make it tricky
because negative numbers makes min into max, and max into min

So we need two varaibles to keep track of min and max.
We also need to swap these two variables when we encounter a negative value.

https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity

*/

class Solution {
    public int maxProduct(int[] nums) {
        
        if (nums == null || nums.length == 0){
            return -1;
        }
        
        int minContProduct = 1;
        int maxContProduct = 1;
        int globMaxProduct = nums[0];
        
        for (int i = 0; i < nums.length; i++){
            
            if ( nums[i] < 0){
                int temp = minContProduct;
                minContProduct = maxContProduct;
                maxContProduct = temp;
            }
            
            maxContProduct = Math.max(maxContProduct * nums[i], nums[i]);
            minContProduct = Math.min(minContProduct * nums[i], nums[i]);
            
            globMaxProduct = Math.max(globMaxProduct, maxContProduct);
            
        }
        
        return globMaxProduct;
        
    }
}
