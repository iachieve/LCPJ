/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = length(headA);
        int bLen = length(headB);
        int delta = 0;
        
        if(aLen > bLen) {
            delta = aLen - bLen;
            headA = advance(headA, delta);
        }
        else {
            delta = bLen - aLen;
            headB = advance(headB, delta);
        }
        
        
        while(headA != null && headB!= null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    private ListNode advance(ListNode node, int count){
        while(count > 0){
            if(node.next == null) return node;
            node = node.next;
            count--;
        }
        return node;
    }
    
    private int length(ListNode head) {
    if (head == null) {
      return 0;
    }
​
