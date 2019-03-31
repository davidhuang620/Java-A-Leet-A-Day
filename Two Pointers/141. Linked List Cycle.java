/*
2 Approaches

Slow Fast Pointer Approach
O(n + k) Time, O(1) Space

HashTable Approach
O(1) Time, O(n) Space

*/



// Slow Fast Pointer Approach

public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if (head == null || head.next == null){
            return false;
        }
        
        ListNode pt = head;
        ListNode pt2 = head.next.next;
        
        while (pt2 != null && pt2.next != null){
            if (pt == pt2){
                return true;
            } 
            pt = pt.next;
            pt2 = pt2.next.next;
        }
        
        return false;
        
    }
}


// HashTable Approach
// O(1) Time; O(N) Space

public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if (head == null){
            return false;
        }
        
        HashSet<ListNode> set = new HashSet<>();
        
        while (head != null){
            if (set.contains(head)){
                return true;
            } 
            
            set.add(head);
            head = head.next;
            
        }
        
        return false;
        
    }
}
