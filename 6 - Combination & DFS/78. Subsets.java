/* THERE ARE 4 SOLUTIONS!

1. DFS general
2. DEF decision tree
3. BFS with queue
4. BIT manipulation

*/


/*
SOLUTION 1

For every index, we add in every element after the index

N = Null

         
    1       2   3
  2   3   3   
3       

*/
public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null){
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
            subset.add(nums[i]);
            comb(nums, i + 1, subset, ans);
            subset.remove(subset.size() - 1);
        }
        
    }
}



/*

SOLUTION 2 

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
ADD every subset at THE END of the recursion!

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


/*

Solution 3 

BFS with QUEUE

第一层: []
第二层: [1] [2] [3]
第三层: [1, 2] [1, 3], [2, 3]
第四层: [1, 2, 3]

*/


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null){
            return ans;
        }
        if (nums.length == 0){
            ans.add(new ArrayList<Integer>());
            return ans;
        }
        Arrays.sort(nums);
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<Integer>());

        
        while (!queue.isEmpty()){
            ArrayList<Integer> subset = queue.poll();
            ans.add(subset);
            for (int j = 0; j < nums.length; j++){
                if (subset.size() == 0 || nums[j] > subset.get(subset.size() - 1)){
                    ArrayList<Integer> next = new ArrayList<Integer>(subset);
                    next.add(nums[j]);
                    queue.add(next);
                }
            }
            
        }
        return ans;
    }
    
}
