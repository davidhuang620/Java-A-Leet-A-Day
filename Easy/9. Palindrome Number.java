class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        
        int newX = 0;
        while (x > newX){
            newX *= 10;
            newX += x % 10;
            x /= 10;
        }
        
        return x == newX || x == newX/10;
        
    }
}
