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
    // two pointers technique (slow and fast)
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // ListNode secondHalfHead = reverseReclursiveley(slow.next);
        ListNode secondHalfHead = reverseIterative(slow.next);
        ListNode firstHalfHead = head;
        
        while(secondHalfHead !=null && firstHalfHead != null){
            
            if(secondHalfHead.val != firstHalfHead.val){
                return false;
            }
            secondHalfHead = secondHalfHead.next;
            firstHalfHead = firstHalfHead.next;
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
