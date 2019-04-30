/*

Notice the time complexity is different than sorting 
sorting is O(nLogn)
while min heap is O(nLogk)

*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if (nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }
        
        Queue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums){
            minHeap.add(num);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.poll();        
    }    
}
