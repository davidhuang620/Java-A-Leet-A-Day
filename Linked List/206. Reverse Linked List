// 206. Reverse Linked List

/* keys:

Draw graphs so we know the relationship of the 3 nodes we need to keep track of.

*/

Iterative:

class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null){
            return null;
        }
        
        ListNode pt2 = head.next;
        head.next = null;
        
        while(pt2 != null){
            ListNode temp = pt2.next;
            pt2.next = head;
            head = pt2;
            pt2 = temp;
        }
        
        return head;
    }
}
