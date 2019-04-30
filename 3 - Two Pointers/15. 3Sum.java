/*

HIGH FREQUENT PROBLEM 3 SUM

Worth practicing again and again, no AC for 5 straight times
Boundary check and deduping process are a lot to consider in this problem
3 SUM -> 3 DEDUP process !!!

O (n ^ 2) TIME     
O (1) SPACE

*/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if (nums == null || nums.length == 0){
            return ans;
        }
        
        // Sorting O(nlogn), a sorted array is necessary for two pointers algo 
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 1; i++){

            // 1 DEDUP low = i + 1 
            // no looking back on previous numbers where i < low
            //
            int low = i + 1, up = nums.length - 1;
            
            // 2 DEDUP (i == 0 || nums[i] != nums[i - 1])
            // pass on any duplicate nums[i]
            //
            if (i == 0 || nums[i] != nums[i - 1]){
                while (low < up){
                    if (nums[low] + nums[up] == -nums[i]){
                        List<Integer> arr = Arrays.asList(nums[i], nums[low], nums[up]);
                        ans.add(arr);
                        low++;
                        up--;
                        
                        // 3 DEDUP (low < up && nums[low] == nums[low - 1])
                        // 1. Pass on and duplicate nums[low] or nums[up]
                        // 2. Set up low < up so we won't kept moving index to out of bounds
                        // 3. either one will work:  
                        //    low++;  while(low < up && nums[low] == nums[low - 1]){ low++; }
                        //    while(low < up && nums[low] == nums[low + 1]){ low++; }  low++;  
                        // 
                        while(low < up && nums[low] == nums[low - 1]){ low++; }
                        while(low < up && nums[up] == nums[up + 1]){ up--; }
                        
                    } else if (nums[low] + nums[up] > -nums[i]){
                        up--;
                    } else{
                        low++;
                    }
                }    
            }
        }
        
        return ans;
        
    }
}
