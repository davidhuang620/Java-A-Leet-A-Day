
class Solution {
    public boolean isPalindrome(String s) {
        if ( s.isEmpty() || s == null) {
            return true;
        }
        
        // int l = s.length() / 2 - 1;
        // int r = s.length() % 2 == 0 ? s.length()/2 : s.length()/2 + 1; 
        
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
