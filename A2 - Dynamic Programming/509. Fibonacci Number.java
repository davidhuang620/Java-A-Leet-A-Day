
/*

Time complexity of recursion solution is O(2^n)

*/


// Dynamic Programming

class Solution {
    public int fib(int N) {
        
        ArrayList<Integer> arr = new ArrayList <Integer>();
        arr.add(0);
        arr.add(1);
        
        for(int i = 2; i <= N; i++){
            arr.add( arr.get(i-2) + arr.get(i-1) );
        }
        
        return arr.get(N);
    }
}

// Recursion

class Solution {
    public int fib(int N) {
        
        if( N==0 ){ return 0;}
        if( N==1 ){ return 1;}
    
        return fib(N-1) + fib(N-2);
        
    }
}
