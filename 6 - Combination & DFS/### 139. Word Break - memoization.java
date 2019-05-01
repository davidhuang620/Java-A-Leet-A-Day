/*

Regular searching will cause Time Limit Error
Since we are searching on the same combination again and again, 
we should use memoization to skip parts that we have searched on before.

use a Boolean[] Memo to keep track of that 
(Boolean type could be null, while boolean can't)

*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0){
            return false;
        }
        
        return helper(s, 0, new HashSet<>(wordDict), new Boolean[s.length()]);
        
    }
    
    private boolean helper(String str, int index, HashSet<String> wordSet,
                          Boolean[] memo){
        // Search is done, we did not return false early,
        // return true;
        if (index == str.length()){
            return true;
        }
        
        // if we have searched on the parts that starts with index,
        // memo[index] will not be null
        // therefore, if it is null, we just return whatever result we got previously
        // THIS IS THE MAIN PART THAT WE SKIP FOR THE DUPLCIATE SEARCH
        if (memo[index] != null){
            return memo[index];
        }
        
        // Try out every length of combination starts at index
        for (int i = index + 1; i <= str.length(); i++){
            // If the part is in the wordSet
            if (wordSet.contains(str.substring(index, i))){
                // Search and put the result in memo
                memo[index] = helper(str, i, wordSet, memo);
                // if the result if true, we can just skip everything and return true
                if (memo[index]){
                    return true;
                }                 
            }
        }
        // we have done every combination that starts with index, let mark it as false
        memo[index] = false;
        return false;
    }
}



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
