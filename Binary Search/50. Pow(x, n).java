
        /* 
        integer max = 2 ^ 31 -1 = 2147483647
        integer min = - 2 ^ 31 =  - 2147483648
        
        since n is a 32-bit signed integer, within the range [−2 ^ 31, 2 ^ 31 − 1]
        we need a long varaible to hold it
        
        */


class Solution {
    public double myPow(double x, int n) {
        
        if (x == 0){ 
            return 0;
        }
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return x;
        }
        

        long exp = n;
        
        // variables declared in if else will get deleted after the if else
        double val = x;
        if (exp < 0){
            val = 1 / x;
            exp = -exp;
        }
        
        double multi = 1;
        
        while (exp > 1){
            if (exp % 2 ==1){
                multi *= val;
                exp--;
            }
            val *= val;
            exp /= 2;
        }
        
        return multi * val;

    }
}
