/*

generate a hash code for the whole string such that we can compare Strings in constant time.

Finding a string in another bigger string,  
Time Complexity: O(m + n)  
m = string a length  
n = string b length  

*/
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null ) return -1;
        if (needle.length() == 0) return 0;
        
        int needleHash = hash(needle);
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++){
            int j = i + needle.length();
            if (hash(haystack.substring(i, j)) == needleHash){
               if (haystack.substring(i, j).equals(needle)){
                   return i;
               }
            }
        }
        
        return -1;
        
    }
    
    public int hash(String str){
        
        int ret = 0;
        for (int i = 0; i < str.length(); i++){
            ret = ((ret * 31) + (int)str.charAt(i)) % 100000;
        }
        return ret;
    }
    
}
