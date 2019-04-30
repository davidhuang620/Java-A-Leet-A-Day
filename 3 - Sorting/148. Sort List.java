
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null){ 
            return head; 
        }
        return mergeSort(head); 
    }
    
    private ListNode mergeSort(ListNode head){
        
        if (head.next == null){
            return head;
        }
        
        // mergeSort n2 first, because we are setting mid.next = null later;
        ListNode mid = getMid(head);
        ListNode n2 = mergeSort(mid.next);
        
        // setting mid.next to null for the first half, otherwise it's an infinite loop
        mid.next = null;
        ListNode n1 = mergeSort(head);
        
        return merge(n1, n2);
    }
    
    private ListNode merge(ListNode n1, ListNode n2){
        ListNode head = new ListNode(0);
        ListNode pt = head;
        
        while (n1 != null && n2 != null){
            if (n1.val > n2.val){
                pt.next = n2;
                pt = pt.next;
                n2 = n2.next;
            } else {
                pt.next = n1;
                pt = pt.next;
                n1 = n1.next;
            }
        }
        
        if (n1 != null){
            pt.next = n1;
        }
        
        if (n2 != null){
            pt.next = n2;
        }
        
        return head.next;
        
    }

    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // better think through if we want slow or slow.next
        return slow;
    }
    
}
