class Solution {
    public ListNode swapPairs(ListNode head) {
        // sanity
        if(head == null || head.next == null) return head;
        // three pointers
        ListNode first = head, second = head.next, startOfNewSegment = null;
        // set new head to second node
        head = head.next;
        while(true){
            // advance pinter(1/3)
            startOfNewSegment = second.next;
            
            // wire (1/2)
            second.next = first;
            
            // end of last pass, wire first 
            // return head
            if(startOfNewSegment == null || startOfNewSegment.next == null){
                first.next = startOfNewSegment;
                return head;
            }
            // wire (2/2)
            first.next = startOfNewSegment.next;
            // advance pointer(2/3)
            first = startOfNewSegment;
            // advance pointer(3/3)
            second = startOfNewSegment.next;
        }
    
    }
}
​
​
​
​
​
