/*

You can prove that: say A length = a + c, B length = b + c, after switching pointer, 
pointer A will move another b + c steps, pointer B will move a + c more steps, 
since a + c + b + c = b + c + a + c, it does not matter what value c is. 
Pointer A and B must meet after a + c + b (b + c + a) steps. If c == 0, they meet at NULL.
Thanks, hpplayer. This solution is very smart.

*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
    
        ListNode aPt = headA, bPt = headB;
        ListNode aLast = null, bLast = null;
        
        while (aPt != bPt){
            aPt = aPt == null ? headB : aPt.next;
            bPt = bPt == null ? headA : bPt.next;
        }
        
        return aPt;
    }
}
