/*

Quick select O(n)
Heap O(N LogN)

*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
    
        if (points == null || points.length == 0 || points[0].length == 0){
            return new int[0][0];
        }
    
        quickSelect(points, 0, points.length - 1, k);
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++){
            ans[i] = points[i];
        }
        return ans;
    }
    
    private void quickSelect(int[][] points, int start, int end, int k){
        
        if (start >= end){
            return;
        }
        
        int low = start, up = end; 
        int pivot = dist(points[(start + end)/2]);
        
        while (low <= up){
            while (low <= up && (dist(points[low]) < pivot)){
                    low++;
            }
            while (low <= up && (dist(points[up]) > pivot)){
                    up--;
            }
            if (low <= up){
                int[] temp = points[low];
                points[low] = points[up];
                points[up] = temp;
                low++;
                up--;
            }
        }
        
        if (up >= k){
            quickSelect(points, start, up, k);
        }
        if (low <= k){
            quickSelect(points, low, end, k);
        }

    }
    
    private int dist(int[] pointVal){
      return pointVal[0] * pointVal[0] + pointVal[1] * pointVal[1];
    }
    
}
