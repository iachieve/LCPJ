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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode right = dummy;
        ListNode left = dummy;
        while(right.next != null){
            right = right.next;
            if(n-- <= 0){
                left = left.next;
            }
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
