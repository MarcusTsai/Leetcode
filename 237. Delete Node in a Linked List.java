/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if (node.next==null) {
           node = null;
           return;    
        }
        /*
         * replace deleted node val & next_ptr with 
         * next node val & next_ptr of next node 
         */
        node.val = node.next.val;
        node.next = node.next.next;
    }
}