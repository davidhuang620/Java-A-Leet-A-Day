




class Solution {
    public String longestPalindrome(String s) {
        
        if(s.isEmpty()){return "";}
        if(s.length()==1){return s;}
        
        String ans = s.substring(0,1);
        
        for (int i = 0; i < s.length(); i++){
            String subString = subStringLoop( i-1, i+1, s);
            ans = ans.length() >= subString.length() ? ans : subString;
        }
        
        for (int j = 0; j < s.length()-1; j++){
            String subString = subStringLoop( j, j+1, s);
            ans = ans.length() >= subString.length() ? ans : subString;
        }
        
        return ans;
        
    }
    
    public String subStringLoop(int front, int back, String s){
        
        while( front >= 0 && back < s.length()){
            if( s.charAt(front) != s.charAt(back) ){
                break;
            }
            front --;
            back ++;
        }
        
        return s.charAt(front+1) == s.charAt(back-1) ? s.substring( front+1, back) : "";
        
    }
    
}
