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
    // two pointers technique (slow and fast)
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode leftHead = head;
        ListNode rightHead = reverseIterative(slow.next);
        
        while(leftHead !=null && rightHead !=null){
            if(leftHead.val != rightHead.val) return false;
            
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        return true;
    }
    
    /*
    Runtime: 1 ms, faster than 95.58% of Java online submissions for Palindrome Linked List.
    Memory Usage: 41.3 MB, less than 6.79% of Java online submissions for Palindrome Linked List.
    */
    private ListNode reverseIterative(ListNode head){
        ListNode curr = head, prev = null, next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    /*
    Runtime: 3 ms, faster than 27.96% of Java online submissions for Palindrome Linked List.
    Memory Usage: 46.7 MB, less than 6.79% of Java online submissions for Palindrome Linked List.
    */
    private ListNode reverseReclursiveley(ListNode head){
      if(head == null || head.next == null) return head;
        ListNode newHead = reverseReclursiveley(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
