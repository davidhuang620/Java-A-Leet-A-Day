// clean

class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) return "";
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i += 2*k){
            int start = i, end = Math.min(i + k - 1, sArr.length - 1);
            while(start < end){
                char temp = sArr[start];
                sArr[start++] = sArr[end];
                sArr[end--] = temp;
            }
            
        }
        return new String(sArr);
    }
    
}

// longer

class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) return "";
        boolean rev = true;
        int start = 0, end = start + k;
        String ans = "";
        while (end < s.length()){
            ans += rev ? reverse(s.substring(start, end)) : s.substring(start, end);
            start += k;
            end += k;
            rev = !rev;
        }
        ans += rev ? reverse(s.substring(start, s.length())) : s.substring(start, s.length());
        return ans;
    }
    
    private String reverse(String s){
        if (s == null || s.length() == 0) return "";
        int low = 0, up = s.length() - 1;
        char sArr[] = s.toCharArray();
        while (low < up){
            char temp = sArr[low];
            sArr[low] = sArr[up];
            sArr[up] = temp;
            low++;
            up--;
        }
        return String.valueOf(sArr);
    }
    
}
