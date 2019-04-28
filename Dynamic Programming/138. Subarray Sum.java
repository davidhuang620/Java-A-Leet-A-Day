/*

Important Logic:  

Running Sum - Target Sum = Target k

adding map(0, 0) in the front
Swift index by 
map.put(runningSum, i + 1);

*/


public class Solution {

    public List<Integer> subarraySum(int[] nums) {
       
       List<Integer> ans = new ArrayList<Integer>();
       
       if (nums == null || nums.length == 0){
           return ans;
       }
       
       HashMap<Integer, Integer> map = new HashMap<>();
       int runningSum = 0;
       // 0 so we can subtract on index 0 later;
        map.put(0, 0);
       
       for (int i = 0; i < nums.length; i++){
           runningSum += nums[i];
           if (map.containsKey(runningSum)){
               
               ans.add(map.get(runningSum));
               ans.add(i);
               return ans;
           }
           
           // be careful of the boundary here 
           // + 1 
           // since we did map.put(0, 0), every index swift by 1
           map.put(runningSum, i + 1);
       }
       
       return ans;
    }
}
