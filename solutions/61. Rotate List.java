class Solution {
    public ListNode rotateRight(ListNode head, int k) {
       if(head == null || head.next == null) return head;
        ListNode oldTail = head, newTail = head;
        int len;
        for (len = 1; oldTail.next != null; len++) oldTail = oldTail.next;
        for(int i = 0; i < len - k % len - 1; i++) newTail = newTail.next;
        oldTail.next = head;
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
