/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
      if(head==null || k==0) {
        return head;  
      }  
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      
      ListNode fast = dummy, slow = dummy;
      
      int len = 0;
      for(; fast.next!=null; fast=fast.next) {
         len++;
      }
      
      for(int i=0; i<len - k%len; i++) {
         slow = slow.next; 
      }
      /* rotation
       * neet to circulate the LinkedList 
       * and then break the list 
       */
      fast.next = dummy.next;
      dummy.next = slow.next;
      slow.next = null;
      
      return dummy.next;
    }
}