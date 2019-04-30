// 21. Merge Two Sorted Lists
// https://leetcode.com/problems/merge-two-sorted-lists/

// 
keys:
be aware of empty cases
be aware of the last iteration
be aware of when node turns null
Initialize object
//


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null){
            return null;
        }
        
        ListNode head = new ListNode(0);
        ListNode pter = head;
        
        while(l1 != null || l2 != null){
            
            if(l1 == null){
                pter.next=l2;
                break;
            }
            
            if(l2 == null){
                pter.next = l1;
                break;
            }
            
            if(l1.val < l2.val){
                pter.next = l1;
                l1 = l1.next;
                pter = pter.next;
            }else{
                pter.next = l2;
                l2 = l2.next;
                pter = pter.next;
            }
            
        }
        
        return head.next;
        
    }
}


