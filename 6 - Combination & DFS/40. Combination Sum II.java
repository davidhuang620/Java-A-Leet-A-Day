class Solution {
    
     public List<List<Integer>> combinationSum2(int[] cand, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (cand == null || cand.length == 0){
            return ans;
        }
        Arrays.sort(cand);
        dfs(cand, target, 0, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void dfs(int[] cand, int target, int index, int sum,
                    List<Integer> subset, List<List<Integer>> ans){
        if (index > cand.length){
            return;
        }
        if (target == sum){
            ans.add(new ArrayList<Integer>(subset));
            return;
        }
        for (int i = index; i < cand.length; i++){
            if (i > 0 && cand[i] == cand[i - 1] && i > index){
                 continue;
            }
            if (sum + cand[i] <= target){
                subset.add(cand[i]);
                dfs(cand, target, i + 1, sum + cand[i], subset, ans);
                subset.remove(subset.size() - 1);
            }
        }
                        
    }
    
}
