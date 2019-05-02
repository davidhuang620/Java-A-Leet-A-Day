/*

N = number of total items
K = number of lists

Heap: O(Nlogk)
Merge: O(Nlogk)

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

Heap

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



/*

Merge

*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        return helper(lists, 0, lists.length - 1);
    }
    
    private ListNode helper(ListNode[] lists, int start, int end){
        
        if (start == end){
            return lists[end];
        }   
        
        ListNode left = helper(lists, start, (start+end)/2);
        ListNode right = helper(lists, (start+end)/2 + 1, end);
        
        ListNode root = new ListNode(0);
        ListNode pt = root;
        while (left != null && right != null){
            if (left.val < right.val){
                pt.next = left;
                pt = pt.next;
                left = left.next;
            } else {
                pt.next = right;
                pt = pt.next;
                right = right.next;
            }
        }
        
        if (left != null){
            pt.next = left;
        }
        if (right != null){
            pt.next = right;
        }
        
        return root.next;
    }  
}
