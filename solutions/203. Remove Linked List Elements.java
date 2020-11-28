// 1
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0, head), pre = sentinel, cur = head;
        while (cur != null) {
            if (cur.val == val) pre.next = cur.next;
            else pre = cur;
            cur = cur.next;
        }
        return sentinel.next;
    }
}
