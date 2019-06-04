/*

IT IS TRICKY
NEED to know both iterative and recursive

This explanation is pretty helpful
https://leetcode.wang/leetCode-50-Pow.html

*/

// Iterative

class Solution {
    public double myPow(double x, int n) {
        
        if (n == 0) return 1;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
       
        double res = 1;
        double product = x;
        while (N >= 1){
            if (N % 2 == 1){
                res = res * product;
            }
            product = product * product;
            N /= 2;
        }
        return res;
    }

}


// Recursive

class Solution {
    public double myPow(double x, int n) {
        
        if (n == 0) return 1;
        // convert it to long for the edge case when 
        // n = Integer.MIN_VALUE,
        // -n = Integer.MIN_VALUE
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        return helper(x, N);
    }
    
    private double helper(double x, long n){
        if (n == 1) return x;
        double half = helper(x, n/2);
        if (n % 2 == 0){
            return half * half;
        } else {
            return half * half * x;
        }
        
    }
    
}
