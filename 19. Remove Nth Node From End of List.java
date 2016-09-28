/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // better version
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode fakehead = new ListNode(0);
      if(head!=null && n>=1) {
          
        if(head.next==null && n==1){
          return null;    
        }
        fakehead.next = head;
        ListNode fast = fakehead;
        ListNode slow = fakehead;
        
        /* n=1, fast-slow gap 2 step so that
         * we can move the node between two
         * without lastptr
         */
        for(int i=0; i<n+1; i++) {
           fast = fast.next;    
        }
        
        while(fast!=null){
           fast = fast.next; 
           slow = slow.next;
        }
        slow.next = slow.next.next;
      }  
      
      return fakehead.next;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode fakehead = new ListNode(0);
      if(head!=null && n>=1) {
          
        if(head.next==null && n==1){
          return null;    
        }
        fakehead.next = head;
        ListNode ptr1 = fakehead;
        ListNode ptr2 = fakehead;
        ListNode lastptr = ptr2;
        
        while(n>0) {
           ptr1 = ptr1.next;    
           n--;
        }
        
        while(ptr1!=null){
           ptr1 = ptr1.next;
           lastptr = ptr2;
           ptr2 = ptr2.next;
        }
        System.out.println(lastptr.val);
        lastptr.next = ptr2.next;
      }  
      
      return fakehead.next;
    }
}