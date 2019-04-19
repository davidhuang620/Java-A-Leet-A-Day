/*

Very similar to combination
but in comb we use index, here we NEED to use a bool[];

因為排列是要排“還沒排過的數字”，而這數字可能會出現在指針前後。

舉個例，你進行到[1,2,3] 時，
back track 變成[1,2] 再變成 [1], 進行for loop中下個 Index [1, 3]
這時因為指針已經到了底 (3 是最後一個數字) 所以你就跳出來了

你也沒加到 [1, 3, 2]，這在組合問題裡是正確的，因為 [1, 2, 3] 跟 [1, 3, 2] 算同個解。
但是在排列裡，因為 [1, 2, 3] 跟 [1, 3, 2] 算不同解，兩個都要加進答案。
但是因為你用指針，到了 3 後，就沒辦法指回 2 了，排列會出錯。

所以才用visited  數列，這樣你才能加到“整個數列還沒加到的數字，不論該數在指針前後”。
因為下個要加的數字有時在你目前的指針前，有時在指針後。


*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return ans;
        }
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void helper(int[] nums, int index, 
                        List<Integer> perm, List<List<Integer>> ans){
        if (perm.size() == nums.length){
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        
        for (int i = index; i < nums.length; i++){
                perm.add(nums[i]);
                helper(nums, i + 1, perm, ans);
                perm.remove(perm.size() - 1);
        }
        
    }
    
}
