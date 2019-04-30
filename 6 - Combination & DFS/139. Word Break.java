/*

Recursive with memoization
with 2d array

*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 ||wordDict == null){
            return false;
        }
        HashSet<String> set = new HashSet<>(wordDict);
        Boolean[][] memo= new Boolean[s.length() + 1][s.length() + 1];
        return helper(0, 1, s, set, memo);
    }
    
    private boolean helper(int start, int end, 
                           String s, HashSet<String> set,
                           Boolean[][] memo){
        
        if (memo[start][end] != null){
            return memo[start][end];
        }
        
        if (end == s.length()){
            boolean res = set.contains(s.substring(start, end));
            return res;
         }
        
        boolean cut = false;
        if (set.contains(s.substring(start, end))){
            cut = helper(end, end + 1, s, set, memo);
        }
        
        boolean notCut = helper(start, end + 1, s, set, memo);
        
        memo[start][end] = cut || notCut;
        return cut || notCut;
        
    }
}


/*

Recursive + for loop
with 1d array

*/

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
