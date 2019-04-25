/*

We can write new comparator in the function
It's a lot faster than Lambda!
*/
        Queue<ListNode> minHeap = new PriorityQueue<>( 
            new Comparator<ListNode>(){
                public int compare (ListNode a, ListNode b){
                    return a.val - b.val;
                }
            });
/*


*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists == null || lists.length == 0){
            return null;
        }
        
        Queue<ListNode> minHeap = new PriorityQueue<>( 
            new Comparator<ListNode>(){
                public int compare (ListNode a, ListNode b){
                    return a.val - b.val;
                }
            });
        for (ListNode node : lists){
            if (node != null){
                minHeap.add(node);            
            }
        }
        
        ListNode ans = new ListNode(0);
        ListNode pt = ans;
        
        while (!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            if (node.next != null){
                minHeap.add(node.next);
            }
            pt.next = node;
            pt = pt.next;
        }
        
        return ans.next; 
    }
}
