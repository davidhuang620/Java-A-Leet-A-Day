class Solution {
    public int mySqrt(int x) {
        
        // edge cases where x = 0, 1
        if (x <= 1) return x;
        
        int low = 0, up = x;
        while (low + 1 < up){
            int pivot = low + (up - low)/2;
            // prevent overflow, don't use pivot * pivot > x
            if (pivot > x/pivot){
                up = pivot;
            } 
            if (pivot <= x/pivot){
                low = pivot;
            }
        }
        return low;
    }
}
