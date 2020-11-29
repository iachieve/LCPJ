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
​
class Solution {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
    Memory Usage: 38.8 MB, less than 6.65% of Java online submissions for Reverse Linked List.
    */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
    
    if(head== null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
        
 
    // save next listnode
    // reverse current node prev
    // advance prev
    // advance curr
    public ListNode reverseListIterative(ListNode head) {
        ListNode curr = head, prev = null, next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null, temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
