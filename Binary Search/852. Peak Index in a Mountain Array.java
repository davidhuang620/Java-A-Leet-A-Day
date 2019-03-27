class Solution {
    public int peakIndexInMountainArray(int[] A) {
        
        // if (A == null || A.length == 0){
        //     return -1;
        // }
        
        int low = 0, up = A.length - 1;
        while (low + 1 < up){
            
            int mid = low + (up - low) / 2;
            if (A[mid - 1] < A[mid] && A[mid + 1] < A[mid]){
                return mid;
            } else if (A[mid - 1] > A[mid]){
                up = mid;
            } else{
                low = mid;
            }
        }
        
        return A[low] > A[up] ? low : up;
        
    }
}
