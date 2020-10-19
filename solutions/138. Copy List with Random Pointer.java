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
// deep copy => new whole list with new memory location
// solution #2 using Wiring Pointers T:O(n) S:O(1)
​
class Solution {
​
    public Node copyRandomList(Node head) {
            Node curr = head;
            Node tempPtr = null;
​
            // first pass
            // clone & change curr.next reference to the new clone
            while(curr != null){
              tempPtr = curr.next;
              Node copy = new Node(curr.val);
              curr.next = copy;
              copy.next = tempPtr;
              curr = tempPtr;
            }
​
            // second pass
            // update clone's random reference
            curr = head;
            while(curr != null){
              if(curr.random!= null) 
                  curr.next.random = curr.random.next;
              curr = curr.next.next; // <<<=====
            }
​
            // third pass
            curr = head;
            Node dummyHead = new Node(-1);
            Node cloneListTail = dummyHead;
            Node copy = null;
            while(curr !=null){
              tempPtr = curr.next.next; // carry reference to curr.next
              copy = curr.next;
              // append the copy to the final list tails
​
              cloneListTail.next = copy; // building the clone linkedlist
              cloneListTail = copy; // advance cloneListTail pointer
​
              // restore curr's next value
              curr.next = tempPtr;
              // advance pointer
              curr = tempPtr;
            }
            return dummyHead.next;
        /*
       // solution 1 using hashmap T:O(n) S:O(n)
