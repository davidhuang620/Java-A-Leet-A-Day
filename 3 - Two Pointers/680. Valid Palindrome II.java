class Solution {
    public boolean validPalindrome(String s) {
        
        if (s==null || s.length() == 0){
            return false;
        }
        
        int i = 0, j = s.length() - 1;
        
        while(i < j){
            if (s.charAt(i) != s.charAt(j)){        
                return paliLoop(s, i+1, j) || paliLoop(s, i, j-1);
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    private boolean paliLoop(String s, int i, int j){
        
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false; 
            }
            i++;
            j--;
        }
        return true;
    }
}
