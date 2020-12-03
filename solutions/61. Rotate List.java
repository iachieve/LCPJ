class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode oldTail = head, newTail = head, newHead = null;
        int len;
        for (len = 1; oldTail.next != null; ++len) oldTail = oldTail.next;
        for (int i = 0; i < len - k % len - 1; ++i) newTail = newTail.next;
        oldTail.next = head;
        newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
​
//  1   2   3   4   5   6   7   8
