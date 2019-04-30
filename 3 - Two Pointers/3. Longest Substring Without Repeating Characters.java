// 3. Longest Substring Without Repeating Characters

/* keys:

Sliding Windows (two pointers)
- in Substring problems: 
    One pointer at the start of the substring, one at the end. 
    There's no discounity in the Substring, string between (i,j) is all we cared about.
- when sliding the window of (i,j), we achieve O(n).


HashMap <Character, Integer> tableName = new HashMap <Character, Integer>;
1. use HashMap instead of HashTable.
2. use Integer instead of int.
3. use Characters instead of String.

length() instead of length

check if a int not exist use (intVariable == null)

String is not char

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int low = 0, up = 0; up < s.length(); up++){
            if (map.containsKey(s.charAt(up))){
                // we may encounter old index that is behind low 
                // To avoid low going back, we choose the higher index 
                low = Math.max(low, map.get(s.charAt(up)) + 1);
            }
            map.put(s.charAt(up), up);
            max = Math.max(max, up - low + 1);            
        }
        return max;
    }
}
