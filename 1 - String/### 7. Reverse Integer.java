
/*
Key Number to remember:

Integer.MAX_VALUE = (2^31 − 1) = 2147483647

Integer.MIN_VALUE = (- 2^31) = -2147483648


Pre Check on Int Ranges
check it first with (int MAX or MIN) / 10 
then do the multiplication

*/

class Solution {
    public int reverse(int x) {
        double ans = 0;
        while (x != 0){
            ans = ans + (x % 10) / 10.0;
            x /= 10;
            if (ans >= Integer.MAX_VALUE / 10.0){
                return 0;
            }
            if (ans <= Integer.MIN_VALUE / 10.0){
                return 0;
            }
            ans *= 10;
        }
        return (int) ans;
    }
}

