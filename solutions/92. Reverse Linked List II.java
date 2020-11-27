class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1), pre = dummy;
        dummy.next = head;
        for(int i = 1; i < m; i++) pre = pre.next;
        ListNode curr = pre.next;
        while(m++ < n){
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}
