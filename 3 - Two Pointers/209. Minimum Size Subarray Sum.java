/*

The right pointer can never go backwards, so we can use a for loop on the outside, and a while loop in the inside.
The first pointer will be the backwheel of the bicycle pushing the whole bicycle forward.
The second (right) pointer will only move when some condition is met. 

In two pointers problem, if we are using a for loop, we can just use the index i as one of the pointer.

An int is not null, it may be 0 if not initialized.
so no need to check if (intVariable == null)

*/


class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        if( s < 0 || nums.length == 0 || nums == null){
            return 0;
        }
        
        int pt2 = 0, sum = 0, minLen = nums.length + 1;
        
        for(int i = 0; i < nums.length; i++){
            
            while( sum < s && pt2 < nums.length){
                sum += nums[pt2];
                pt2 ++;
            }
            
            if( sum >= s ){
                minLen = Math.min(minLen, pt2 - i);
                sum -= nums[i];
            }
        }
        
        return minLen == nums.length + 1 ? 0 : minLen;

    }
}
