/*

1 2 3
Y Y Y
N N N

Combination = 2 * 2 * 2
2 choices per number => at every number we do two recursion

N = Null

         N
    1        N
  2   N    2    N
3 N  3 N  3 N  3 N

we can see we have every combination

[
  [1,2,3],
  [1,2],
  [1,3],  
  [1],
  [2,3],
  [2],
  [3],
  []
]

*/


/*
DFS

Every time we add the number in, 
we need to remove it from the subset after the function call
Because it is pointing to the same address of the subset that we just modified

*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        comb(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
     
    private void comb(int[] nums, int index, List<Integer> subset, List<List<Integer>> ans){
        if (index == nums.length){
            ans.add(new ArrayList<Integer>(subset));
            return;
        }
        
        subset.add(nums[index]);
        comb(nums, index + 1, subset, ans);
        subset.remove(subset.size() - 1);

        comb(nums, index + 1, subset, ans);
        
        // another way of doing this, it's basically the same thing
        /*
        comb(nums, index + 1, subset, ans);
        
        subset.add(nums[index]);
        comb(nums, index + 1, subset, ans);
        subset.remove(subset.size() - 1);
        */

        return;
    }
    
}
