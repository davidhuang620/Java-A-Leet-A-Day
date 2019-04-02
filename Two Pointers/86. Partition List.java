/*

Need to set the last node point to null
This is crucial when modifying the original Linked List
It may causes a circular List which leads to an infinite loop when reading

*/



class Solution {
    public ListNode partition(ListNode head, int x) {
        
        if (head == null){ return head;}
        ListNode low = new ListNode(0);
        ListNode up = new ListNode(0);
        ListNode lowHead = low;
        ListNode upHead = up;
        
        while (head != null){
            if (head.val < x){
                low.next = head;
                low = low.next;
                head = head.next;
            } else {
                up.next = head;
                up = up.next;
                head = head.next;
            }            
        }
        
        // up.next = null,
        // This is crucial, otherwise it will cause a circular Linked List
        up.next = null;
        
        low.next = upHead.next;
        return lowHead.next;
    }
}
