/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1, ptr2 = l2, dummy = new ListNode(-1), dummyptr = dummy;
        int carry = 0, sum = 0;
        while(ptr1 != null || ptr2 != null){
            sum = carry;
            
            if(ptr1 != null){
                sum += ptr1.val;
                ptr1 = ptr1.next;
            }
            
              if(ptr2 != null){
                sum += ptr2.val;
                ptr2 = ptr2.next;
            }
            
            dummyptr.next = new ListNode(sum % 10);
            dummyptr = dummyptr.next;
            carry = sum / 10;
        }
        
        if(carry > 0) dummyptr.next = new ListNode(carry);
        return dummy.next;
    }
}
