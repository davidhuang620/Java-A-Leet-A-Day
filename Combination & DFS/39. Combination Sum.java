/*

This problem is similar to subSet
the difference is we need to loop on the same number again

*/
class Solution {
    public List<List<Integer>> combinationSum(int[] cand, int target) {
        if (cand == null || cand.length ==0 ){
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(cand);
        dfs(cand, target, 0, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    private void dfs(int[] cand, int target, int index, int sum,
                    List<Integer> subset, List<List<Integer>> ans){
        if (index > cand.length){
            return;
        }
        if (sum == target){
            ans.add(new ArrayList<Integer>(subset));
            return;
        }
        for (int i = index; i < cand.length; i++){
            if (sum + cand[i] <= target){
                subset.add(cand[i]);
                
                // here we pass in i instead of i + 1
                // since we still want to loop on the same number again
                
                dfs(cand, target, i, sum + cand[i], subset, ans);
                subset.remove(subset.size() - 1);
            }
        }
    }
    
}
