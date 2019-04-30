/*

Start from center and use 2 pointers to expand left and right
O(n ^ 2)

Remeber that there are 2 ways of constructing palindrone:
helper(s, i, i);
helper(s, i, i+1);

three ways of storing the ans:
helper return string (slightly slower)
helper return int (tricky boundary to consider)
helper void, store ans in global scope (short and clean code, bad practice)


*/
class Solution {
    public String longestPalindrome(String s) {
        if ( s == null ) return null;
        if (s.length() == 0 ) return s;
        
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++){
            int len1 = helper(s, i, i);
            int len2 = helper(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start){
                start = i - (len - 1)/ 2;
                end = i + (len /2);
            }
        }
        return s.substring(start, end + 1);
    }
    
    public int helper(String s, int low, int up){
        
        while (low >= 0 && up < s.length() && (s.charAt(low) == s.charAt(up))){
            low--;
            up++;
        }   
        return up - low - 1;
    }
    
}
