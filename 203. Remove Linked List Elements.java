/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null || (head.next==null && head.val==val)) {
          return null;  
        }
  
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode baseptr = phead;
        ListNode runptr = phead.next;
        // two while loop --> time limit exceed
        /*
        while(baseptr!=null) {
          while(runptr!=null && runptr.val==val) {
            runptr = runptr.next; 
          }  
          baseptr = runptr;
        }
        */
        while(runptr!=null) {
           if(runptr.val!=val) {
             baseptr.next = runptr;
             baseptr = baseptr.next;
           }      
           runptr = runptr.next; 
        }
        baseptr.next = null;
        
        return phead.next;
    }
}