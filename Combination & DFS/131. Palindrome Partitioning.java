/*

At every index, we have choice of adding a subset of different length of substring 
The substring start from the current index to (anywhere between index + 1 and string.length()) 

*/

class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.length() == 0){
            return ans;
        }
        dfs(s, 0, new ArrayList<String>(), ans);
        return ans;
    }
    
    private void dfs(String s, int index, 
                     List<String> subset, List<List<String>> ans){
        
        if (index >= s.length()){
            ans.add(new ArrayList<String>(subset));
        }
        
        for (int i = index + 1; i <= s.length(); i++){
            String subStr = s.substring(index, i);
            if (isPalind(subStr)){
                subset.add(subStr);
                dfs(s, i, subset, ans);
                subset.remove(subset.size() - 1);
            }
        }
    }
    
    private boolean isPalind(String subStr){
         int i = 0, j = subStr.length() - 1;
        while (i < j){
            if (subStr.charAt(i++) != subStr.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    
}
