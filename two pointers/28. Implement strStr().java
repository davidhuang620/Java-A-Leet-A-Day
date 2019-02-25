

/* 

Check boundary

*/



class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){ return 0;}
        if(needle.isEmpty()){return 0;}
        if(haystack.isEmpty()){return -1;}
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            // finished loop, needle found
            if (j == needle.length()) {
                return i;
            }
        }
        
        return -1;
    }
}
