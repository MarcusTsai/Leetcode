/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null) {
           return null;  
        }
        if (head.next==null) {
           return head;    
        }
        ListNode ptr = head;
        ListNode lastptr = head;
        
        while (ptr!=null) {
            ListNode tmp = ptr.next;
            if (ptr==head) {
               ptr.next = null;
            } else{
               ptr.next = lastptr;      
            }
            lastptr = ptr;
            ptr = tmp;
        }
        
        return lastptr;
    }
}