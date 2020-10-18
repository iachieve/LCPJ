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
// solution #1 using HashTable T:O(n) S:O(n)
// solution #2 using Wiring Pointers T:O(n) S:O(1)
​
class Solution {
​
    public Node copyRandomList(Node head) {
        Map<Node, Node> cloneMap = new HashMap<>();
        Node curr = head;
        /*
            * 1st pass insert key,value pair into cloneMap
            *   key: original node
            *   value: new node carrying the original value
        */
        while(curr != null){
            cloneMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }
​
        /*
            * give all clones their next & random pointer assignments
            * our clone map let us reach an original nodes in O(1) time
            *   
        */
        // reset pointer to head
        curr = head;
        while(curr != null){
            cloneMap.get(curr).next = cloneMap.get(curr.next);
            cloneMap.get(curr).random = cloneMap.get(curr.random);
            curr = curr.next;
        }
        return cloneMap.get(head);
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
