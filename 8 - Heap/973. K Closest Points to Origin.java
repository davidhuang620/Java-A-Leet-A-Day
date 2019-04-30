/*

Heap O(nLogn)
Using quick select will be faster O(n)

*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0 
            || points[0].length == 0 || k <= 0){
            return new int[0][0];
        }
        
        int[][] ans = new int[k][2];
        Queue<Integer> MaxHeap = new PriorityQueue<>(
            (a, b) -> 
            (points[b][0] * points[b][0] + points[b][1] * points[b][1]) -                 (points[a][0] * points[a][0] + points[a][1] * points[a][1])
        );
        
        for (int r = 0; r < points.length; r++){
            MaxHeap.add(r);
            if (MaxHeap.size() > k){
                MaxHeap.poll();
            }
        }
        
        for (int i = 0; i < k; i++){
            int row = MaxHeap.poll();
            ans[i][0] = points[row][0];
            ans[i][1] = points[row][1];
        }
        return ans;   
    
    }
}


// Comparator

class Solution {
    
    int[][] points;
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0 
            || points[0].length == 0 || k <= 0){
            return new int[0][0];
        }
        this.points = points;
        
        int[][] ans = new int[k][2];
        Queue<Integer> MaxHeap = new PriorityQueue<>(new CompareDist());
        
        for (int r = 0; r < points.length; r++){
            MaxHeap.add(r);
            if (MaxHeap.size() > k){
                MaxHeap.poll();
            }
        }
        
        for (int i = 0; i < k; i++){
            int row = MaxHeap.poll();
            ans[i][0] = points[row][0];
            ans[i][1] = points[row][1];
        }
        return ans;   
    
    }
    
    class CompareDist implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            return (points[b][0] * points[b][0] + points[b][1] * points[b][1]) 
                -  (points[a][0] * points[a][0] + points[a][1] * points[a][1]);
           
        }
    }
    
}
