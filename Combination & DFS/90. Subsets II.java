/*

Follow up question for 78. Subset
duplicates numbers in the array, but not allowing duplicate subset in the ans

EX: [1, 2, 2]
ANS:
[
  [2],
  [1],
  [1,2,2], <- we still want the duplicate numbers to be in our subset
  [2,2],   <- 
  [1,2],
  []
]

The key is only allowing the duplicate number to be add in ONCE
Therefore, in the for loop, we only select the duplicate number when i == index ( index from the paremeter input)
Which means we continue the for loop when the duplicate number appears at i > index

            // nums[i] == nums[i-1] <- it is a duplicate
            // i > index <- the duplicate will have been added ONCE into the subset when i == index,
            // every other times, we do not add in the duplicate

*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null){
            return ans;
        }
        if (nums == null || nums.length == 0){
            ans.add(new ArrayList<Integer>());
            return ans;
        }
        Arrays.sort(nums);
        comb(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void comb(int[] nums, int index, 
                      List<Integer> subset, List<List<Integer>> ans){
        
        ans.add(new ArrayList<Integer>(subset));
        for (int i = index; i < nums.length; i++){
            // nums[i] == nums[i-1] <- it is a duplicate
            // i > index <- the duplicate will have been added ONCE into the subset when i == index,
            // every other times, we do not add in the duplicate
            if (i > 0 && nums[i] == nums[i-1] && i > index){
                continue;
            }
            subset.add(nums[i]);
            comb(nums, i + 1, subset, ans);
            subset.remove(subset.size() - 1);
        }
        
    }
    
}
