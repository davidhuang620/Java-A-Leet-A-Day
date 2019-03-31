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
