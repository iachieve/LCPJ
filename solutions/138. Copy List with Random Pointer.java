/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;
​
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
​
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
            Node ptr = head;
            while (ptr != null) {
                Node newNode = new Node(ptr.val);
                newNode.next = ptr.next;
                ptr.next = newNode;
                ptr = newNode.next;
            }
            ptr = head;
            while (ptr != null) {
                ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
                ptr = ptr.next.next;
            }
​
            Node ptrOldList = head;
            Node ptrNewList = head.next;
            Node headOld = head.next;
            while (ptrOldList != null) {
                ptrOldList.next = ptrOldList.next.next;
                ptrNewList.next = (ptrNewList.next != null) ? ptrNewList.next.next : null;
                ptrOldList = ptrOldList.next;
                ptrNewList = ptrNewList.next;
            }
            return headOld;
        }
    
}
