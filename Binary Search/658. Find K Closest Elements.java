



// implement binary searchby hand

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
