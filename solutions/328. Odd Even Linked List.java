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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode evenPointer = head;
        ListNode oddPointer = head.next;
        ListNode oddHeader = oddPointer;
        
        while(oddPointer != null && oddPointer.next != null){
            evenPointer.next = oddPointer.next;
            evenPointer = oddPointer.next;
            
            oddPointer.next = evenPointer.next;
            oddPointer = evenPointer.next;
        }
        
        evenPointer.next = oddHeader;
        return head;
    }
}
