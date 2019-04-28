/*

DP : Think of parsing the problem into smaller sub problem

https://www.youtube.com/watch?v=2MmGzdiKR9Y


How do I know the max subarray at every index ?

Math.max (sumOfSubArray + nums[i], nums[i]);
At every index, I can choose the larger one between

1. Extend the continuous max subarray 
2. Start a new subarray starting at this index

The continuous max subarray will certainly be the largest subarray we can get at that given index,
because we have been doing the comparison at every index previously.


*/


class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        
        int max = nums[0];
        int sumOfSubarray = 0;
        for (int i = 0; i < nums.length; i++){
            sumOfSubarray = Math.max(sumOfSubarray + nums[i], nums[i]);
            max = Math.max(max, sumOfSubarray);
        }
        
        return max;
        
    }
}
