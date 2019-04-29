/*

loop through twice

*/


class Solution {
    public int longestPalindrome(String s) {

        if (s == null || s.length() == 0){
            return 0;
        }
        
        int[] memo = new int[256];
        for (int i = 0; i < s.length(); i++){
            memo[s.charAt(i) - 'A']++;
        }
        
        int char1 = 0;
        int char2 = 0;
        for (int i = 0; i < 256; i++){
            if (memo[i] % 2 == 1){
                char1 = 1;
            }             
            char2 += memo[i] / 2;
        }
        
        return char1 + char2 * 2;
    }
}
