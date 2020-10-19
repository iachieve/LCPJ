class Solution {
    public ListNode reverseBetween(ListNode head, int start, int end) {
      if(head == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        for(int i=1; i < start; i++) prev = prev.next;
        ListNode first = prev.next;
        while(start < end){
            ListNode second = first.next;
            first.next = second.next;
            second.next = prev.next;
            prev.next = second;
            start++;
        }
        return dummyHead.next;
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
​
​
​
​
​
​
​
​
​
