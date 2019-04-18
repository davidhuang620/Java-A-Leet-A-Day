/*

Remeber two ways of recursion
Divide Conquer Merge 分治合
Divide Merge Conquer 分和治

In this case, Divde merge Conquer will be easier.
since we need to keep track of the index and the correspond substring in the memo,
we need the "index" and "all of the possible combination of substring after index" 
to be at the "same recursion level".

It will be easier to return the List of all of the possible combination of substring after index
back to the recursion level where the index is at.

*/

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0 
            || wordDict == null || wordDict.size() == 0){
            return new ArrayList<String>();
        }
        HashSet<String> wordSet = new HashSet<>(wordDict); 
        HashMap<Integer, ArrayList<String>> memo = new HashMap<>();
        return helper(s, 0, memo, wordSet);
    }
    
    private ArrayList<String> helper(String s, int index, 
                        HashMap<Integer, ArrayList<String>> memo, 
                        HashSet<String> wordSet){
        
        if (memo.containsKey(index)){
            return memo.get(index);
        }
        
        ArrayList<String> subStr = new ArrayList<String>();
        
        if ( index == s.length()){
            subStr.add("");
            return subStr;
        }
        
        for (int i = index + 1; i <= s.length(); i++){
            if (wordSet.contains(s.substring(index, i))){
                ArrayList<String> nextSubStr = helper(s, i, memo, wordSet);
                for (String str : nextSubStr){
                    if (str.equals("")){
                        subStr.add(s.substring(index, i));
                    } else {
                        subStr.add(s.substring(index, i) + " " + str);
                    }
                }
            }
        }
        
        memo.put(index, subStr);
        return subStr;
    }
    
}
