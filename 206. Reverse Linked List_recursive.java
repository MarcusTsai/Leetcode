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
        return helper(head, null);
    }
    
    private ListNode helper(ListNode head, ListNode next) {
        if (head == null){
           return next;    
        }
        ListNode nextNode = head.next;
        head.next = next;
        return helper(nextNode, head);
    }
}