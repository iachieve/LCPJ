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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode startOfNextSegment = null;
        
        head = head.next;
        while(true){
            startOfNextSegment = second.next;
            second.next = first;
​
            if(startOfNextSegment == null || startOfNextSegment.next == null){
                first.next = startOfNextSegment;
                return head;
            }
            
            first.next = startOfNextSegment.next;
            
            first = startOfNextSegment;
            second = startOfNextSegment.next;
        }
    }
}
​
​
​
​
​
​
​
​
​
​
