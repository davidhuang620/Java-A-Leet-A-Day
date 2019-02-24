
/*
keys

In Java, use s.empty instead of s == ""

Always check pointers boundary EVERYTIME we manipulate them.

When problem says ignore something, we need to confirm if we need to DEAL with them TO ignore them or just plainly ignore them. 

*/




class Solution {
    public boolean isPalindrome(String s) {
        
        if ( s.isEmpty() || s == null) {
            return true;
        }
        
        int l = 0;
        int r = s.length() - 1;
        
        s = s.toLowerCase();
        
        while( l < r){
            
            while( l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            
            while( l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            
            if( l > r) {return true;}
            
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }

            l ++;
            r --;
        }
        return true;
    }
}
