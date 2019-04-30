class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode pt = head;
        
        // need to first check if pt.next != null
        while (pt != null && pt.next != null){
            head = head.next;
            pt = pt.next.next;
        }
        
        return head;
    }
}
