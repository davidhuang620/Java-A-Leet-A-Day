

/*

Use helper function to keep code clean.

Draw to make different cases clear.

while can combine with if. 

*/


class Solution {
    public String longestPalindrome(String s) {
        
        if(s.isEmpty() || s == null){return "";}
        if(s.length()==1){return s;}
        
        String ans = s.substring(0,1);
        
        for (int i = 0; i < s.length(); i++){
            
            String subString = subStringLoop( i-1, i+1, s);
            ans = ans.length() >= subString.length() ? ans : subString;

            String subString = subStringLoop( j, j+1, s);
            ans = ans.length() >= subString.length() ? ans : subString;
        }
        
        return ans;
        
    }
    
    public String subStringLoop(int front, int back, String s){
        
        while( front >= 0 && back < s.length() && s.charAt(front) != s.charAt(back)){
            front --;
            back ++;
        }
        
        return s.charAt(front+1) == s.charAt(back-1) ? s.substring( front+1, back) : "";
    }
    
}
