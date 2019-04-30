/*

Notice that the loop condition is similar to quick sort

learn the following function:
Character.isLetterOrDigit(someChar)
Character.isLetter(someChar)
Character.isDigit(someChar)
Character.toLowerCase(someChar)

*/


class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        
        int low = 0, up = s.length() - 1;
        while (low < up){
            while (low < up && !Character.isLetterOrDigit(s.charAt(low))){
                low++;
            }
            while (low < up && !Character.isLetterOrDigit(s.charAt(up))){
                up--;
            }            
            if (low < up && Character.toLowerCase(s.charAt(low)) 
                        != Character.toLowerCase(s.charAt(up))){
                  return false;
            }
            low++;
            up--;
        }
        return true;        
    }
}
