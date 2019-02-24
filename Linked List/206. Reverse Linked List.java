// 206. Reverse Linked List

/* keys:

Draw graphs so we know the relationship of the 3 nodes we need to keep track of.

Recursive: 

1. recursive goes two ways 

    ---> forward 
    ... code ...
    ---> forward
    
    Recursion Function Call
    (Paused and goes into the next recursion)
    (Come back to this line After the next recursion and all of its inner recursions have finished)
    (if we {return recursion-function-call}, or return anything, the following code will not happen)
    
    <--- backward
    ... code ...
    <--- backward
    
    
2. Always traversing 2 times

3. Recursion is a series of calls on call stack

           4 (base case reached, return) 
        3     3
    2             2
1                     1


4. Singly LinkedList could use this technique to traverse backward

5. Use a temp varialbe to store the return objects from the recursion call, so we can execute something backward.

---> forward code

SomeObject tempVariable = recursion-function-call ; 

<--- backward code

return tempVariable;

######################

---> forward code 

return recursion-function-call;

<--- any code here won't be executed



*/

// Recursive:

public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}

// Iterative:

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


