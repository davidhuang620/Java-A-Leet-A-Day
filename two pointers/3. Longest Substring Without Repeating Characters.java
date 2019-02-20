// 3. Longest Substring Without Repeating Characters

/* keys:

Sliding Windows (two pointers)
- in Substring problems: one pointer at the start of the substring, one at the end.


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
        HashMap <Character, Integer> table = new HashMap <Character, Integer>();
        int max = 0;
        
        for(int i = 0, j = 0; j < s.length(); j ++){
            if (table.containsKey(s.charAt(j))){
                i = Math.max(i, table.get(s.charAt(j))+1);
            }
            max = Math.max(max, j-i+1);
            table.put(s.charAt(j),j);
            
            
        }
        
        return max;
        
    }
}
