// Binary Search Library
// On a list: Collections.binarySearch( list, target )
// On an array: Arrays.binarySearch( array, target )
// Returns:
// index of the search key, if it is contained in the array; otherwise, (-(insertion point) – 1). 

// implement binary search by hand

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
     
        List<Integer> ans = new ArrayList<Integer>();
        if (arr == null || arr.length == 0){ return ans; }
        
        int mid = binarySearch(arr, x);

        int low = mid - 1;
        int up = mid + 1;
        
        for(int i = 1; i < k; i++){
            if( up > arr.length - 1){
                low--;
            } else if ( low < 0){
                up++;
            } else if (Math.abs(arr[low] - x) <= Math.abs(arr[up] - x)){
                low--;
            } else {
                up++;
            }
        }
        
        for (int i = low + 1; i < up; i++){
            ans.add(arr[i]);
        }
        
        return ans;
    }
    
    private int binarySearch (int[] arr, int x){
        
        int low = 0, up = arr.length - 1;
        while (low + 1 < up){
            int mid = low + (up - low) / 2;
            if (arr[mid] == x){
                low = mid;
                break;
            } else if (arr[mid] < x){
                low = mid;
            } else{
                up = mid;
            }
        }
        
        return Math.abs(arr[low] - x) <= Math.abs(arr[up] - x) ? low : up;
    }
    
}


/* 
 Using Library

 when index not found, use 
 if (mid < 0){ mid = -mid - 1; }
 
 deal with boundary when index is at the start and the end 
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
     
        List<Integer> ans = new ArrayList<Integer>();
        if (arr == null || arr.length == 0){ return ans; }
        
        // Binary Search Library
        
        int mid = Arrays.binarySearch(arr, x);
        
        // when index not found, use 
        // if (mid < 0){ mid = -mid - 1; }
        // deal with boundary when index is at the start and the end 
        
        if (mid < 0){ 
            mid = -mid - 1; 
            if(mid == arr.length){ mid = arr.length - 1; }
            if(mid != 0 ){
                mid = Math.abs(arr[mid-1] - x) <= Math.abs(arr[mid] - x) ? mid - 1 : mid;   
            }
        }
        
        int low = mid - 1;
        int up = mid + 1;
        
        for(int i = 1; i < k; i++){
            if( up > arr.length - 1){
                low--;
            } else if ( low < 0){
                up++;
            } else if (Math.abs(arr[low] - x) <= Math.abs(arr[up] - x)){
                low--;
            } else {
                up++;
            }
        }
        
        for (int i = low + 1; i < up; i++){
            ans.add(arr[i]);
        }
        
        return ans;
    }
    
}
