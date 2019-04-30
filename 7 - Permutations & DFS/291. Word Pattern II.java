/*

3 keys
1. check if map contains the word already
2. check if the str is already in the map used by another pattern
3. if our search succeed, we return true, 
   if not, we back track and continue searching 

String startsWith(String prefix, int strt_pos):
ex: 
str.startsWith(subStr, sInd)

BIG PLUS, it handles the length problem, 
if subStr exceed str.length() it will just return false

This variant has two argument and tests if a string starts with the specified prefix beginning a specified index.


*/
class Solution {

    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null){
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        return helper(0, 0, pattern, str, map);
    }
    
    private boolean helper(int pInd, int sInd, String pattern, 
                        String str, HashMap<Character, String> map){
        if (pInd == pattern.length() && sInd == str.length()){
            return true;
        }
        if (pInd == pattern.length() || sInd == str.length()){
            return false;
        }
        char p = pattern.charAt(pInd);
        if (map.containsKey(p)){
            String subStr = map.get(p);
            
            // str.startsWith(subStr, sInd) 
            // replace the following
            // if(sInd + subStr.length() <= str.length() &&
            //    subStr.equals(str.substring(sInd, sInd + subStr.length())))
            
            if (str.startsWith(subStr, sInd)){
                return helper(pInd + 1, sInd + subStr.length(), pattern, str, map);
            } else {
                return false;
            }
        }
        for (int i = sInd + 1; i <= str.length(); i++){
            if (map.containsValue(str.substring(sInd, i))){
                continue;
            }
            map.put(p, str.substring(sInd, i));
            // if it is true, we found a solution and return true
            // if it is not true, we wanna backtrack and continue searching
            if (helper(pInd + 1, i, pattern, str, map)){
                return true;   
            }
            map.remove(p);
        }
        return false;
    }
    
}
