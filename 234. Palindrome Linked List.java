/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head!=null && head.next!=null){
          ListNode fast = head;
          ListNode slow = head;
        
          // Search mid point
          while(fast!=null && fast.next!=null) {
             fast = fast.next.next; 
             slow = slow.next;
          }
          slow = reverse(slow);
          fast = head;
          
          while(fast!=null && slow!=null) {
             if(fast.val!=slow.val) {
               return false;     
             } 
             fast = fast.next;
             slow = slow.next;
          }
        }
        return true;
    }
    
    private ListNode reverse(ListNode node) {
        //ListNode fakenode = new ListNode(0);
        //fakenode = node;
        // only replace node need fakenode
        
        ListNode ptr = node;
        ListNode lastnode = null;
        
        while(ptr!=null) {
           ListNode tmp = ptr.next;
           ptr.next = lastnode;
           lastnode = ptr;
           ptr = tmp;
        }
        
        return lastnode;
    }
}