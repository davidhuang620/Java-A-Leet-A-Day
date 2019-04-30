/*

Keep all k largest elements in the min heap,
once the heap size() > k, start polling them

*/

class KthLargest {

    private int k;
    Queue<Integer> minHeap;  
        
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums){
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k){
            minHeap.poll();            
        }
        return minHeap.peek();
    }
}
