class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head, second = head.next, startOfNewSegment = null;
        head = head.next;
        while(true){
            // set pointer to new segment(pair) // advance cursor
            startOfNewSegment = second.next;
            // wire next to first
            second.next = first;
            if(startOfNewSegment == null || startOfNewSegment.next == null){
                first.next = startOfNewSegment;
                return head;
            }
            
            // wire first to the second node in the new pair
            first.next = startOfNewSegment.next;
            
            // advance cursor
            first = startOfNewSegment;
            // advance cursor
            second = startOfNewSegment.next;
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
