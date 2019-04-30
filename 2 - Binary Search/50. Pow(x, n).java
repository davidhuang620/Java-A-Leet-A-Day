
        /* 
        integer max = 2 ^ 31 -1 = 2147483647
        integer min = - 2 ^ 31 =  - 2147483648
        
        since n is a 32-bit signed integer, within the range [−2 ^ 31, 2 ^ 31 − 1]
        we need a long varaible to hold it
        
        Recursive solution is kinda tricky, gotta remeber 
        
        */

/* Recursive */

class Solution {
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }
}




/* Iterative */

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
