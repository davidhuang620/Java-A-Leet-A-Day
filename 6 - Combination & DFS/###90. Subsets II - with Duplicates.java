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
            
            凡是i= startIndex的时候，即便和前一个数相等，也是subset的第一次取到，也是最深的搜索结果一定要获得。 
            如[1,2,2]中subset =[1,2]开始搜索, startIndex将指向第二个2开始搜索(startIndex = 2)，
            但由于开始i==startIndex, 仍然需要取以获得[1,2,2]，只因为和前一个数相等就continue会漏掉[1,2,2]。
            如果i > startIndex, 那么这样的subset必然已经在之前取得过了并且被搜索过， 就是重复的结果了，
            同样对[1,2,2]计算，如subset =[1]的情况下去搜索, startIndex = 1,即从第一个2组成的[1,2]进行搜索， 
            当完成并回溯后，下一个循环中，此时nums[2] = nums[1]且i = 2>startIndex = 1, 
            同样的[1,2]已经在之前的回溯中都获得了全部的搜索结果，所以要continue.

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
