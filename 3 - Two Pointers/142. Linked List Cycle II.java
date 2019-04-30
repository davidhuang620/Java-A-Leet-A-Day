
public class Solution {
    public ListNode detectCycle(ListNode head) {
            
        if (head == null || head.next == null){
            return null;
        }
        
        // Notice: we HAVE to initiate them both as head
        // in order for the pt2 (intersect) to meet with pt at the second while loop
        ListNode pt = head;
        ListNode pt2 = head;
        
        while (pt2 != null && pt2.next != null){
            pt = pt.next;
            pt2 = pt2.next.next;
            // since we initiate pt == pt2 == head
            // we put the if statement after the increment
            if (pt == pt2){
                break;
            } 
        }
        
        if (pt2 == null || pt2.next == null){
            return null;
        }
        
        pt = head;
        
        while (pt != pt2){
            pt = pt.next;
            pt2 = pt2.next;
        }
        return pt2;
        
    }
}
