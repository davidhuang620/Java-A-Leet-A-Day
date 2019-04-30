/*
HashMap 在Array 题目中一般可以用O(n)的时间复杂度解决两种问题
1，求两者之和为固定某数

   if (map.contains(sum - curtValue)) {
       index1 = map.get(sum - curtValue);
       index2 = curtIndex;
       break;
   }
2，求两个index之间的所有数的和为某数

   if (map.contains(curtSum - sum)) {
       index1 = map.get(curtSum - sum);
       index2 = curtIndex;
       break;
   }
   
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        // <runningSum, count>
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // 0 apears one time at the start
        map.put(0, 1);
        int runningSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            runningSum += nums[i];
            // runningSum - targetSum = k
            // => runningSum - k = targetSum
            if (map.containsKey(runningSum - k)){
                count += map.get(runningSum - k);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }      
        return count; 
    }
}



