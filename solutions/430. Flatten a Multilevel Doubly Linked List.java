/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
​
class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        Node p = head;
        while(p != null){
            if(p.child == null){
                p = p.next;
                continue;
            }
            Node tail = p.child;
            while(tail.next != null) tail = tail.next;
            tail.next = p.next;
            //edge case: if p is at the end of the list and has child node
            if(p.next != null) p.next.prev = tail;
            
            p.child.prev = p;
            p.next = p.child;
            p.child = null;
            
            p = p.next;
        }
        
        
        return head;
    }
}
​
​
​
        
        
        
        
        
        
        
        
        
