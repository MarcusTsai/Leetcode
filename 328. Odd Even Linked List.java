public class Solution {





    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null || head.next.next==null) {
           return head;    
        }
        
        ListNode ptr = head;
        ListNode Lastptr = head;
        
        ListNode even = new ListNode(0);
        ListNode ptre = even;
     
        
        while (ptr!=null) {
           ListNode tmp = ptr.next;
           
           if(tmp==null){
             Lastptr=ptr;
             break;
           } else{
             ptr.next = tmp.next;
             Lastptr = ptr;
             ptr = ptr.next;
           }
           
           ptre.next = tmp;
           ptre = ptre.next;
           ptre.next = null;
           
        }
        Lastptr.next = even.next;
        System.out.println("even: " + even.next.val);
        
        return head;
    }
    
    public ListNode oddEvenList(ListNode head) {
    if (head!=null) {
       ListNode odd = head; 
       ListNode even = head.next;
       ListNode evenHead = even;
       
       while(even!=null && even.next!=null) {
           odd.next = odd.next.next;
           even.next = even.next.next;
           odd = odd.next;
           even = even.next;
       }
       odd.next = evenHead;
    }
    
    return head;
    }
}