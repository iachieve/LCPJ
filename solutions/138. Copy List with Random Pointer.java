class Solution {

    public Node copyRandomList(Node head) {
            Node curr = head;
            Node tempPtr = null;

            /* first pass
             *  1- create clones
			 *  2- change curr.next reference to the new clone
			 *  3- change clone's next to be original next
            */
			while(curr != null){
              tempPtr = curr.next;
              Node copy = new Node(curr.val);
              curr.next = copy;
              copy.next = tempPtr; //<<======
              curr = tempPtr;
            }

            // second pass, set clone's random reference
            curr = head;
            while(curr != null){
              if(curr.random!= null) 
                  curr.next.random = curr.random.next;// <<<=====
              curr = curr.next.next; // <<<=====
            }

            /* third pass
				1- build clone list
				2- restore original list
			*/
            curr = head;
            Node dummyHead = new Node(-1);
            Node cloneListTail = dummyHead;
            Node copy = null;
            while(curr !=null){
              tempPtr = curr.next.next; // carry reference to curr.next
              
              // **clone part
			  // append the copy to the final list tails
			  copy = curr.next;
              cloneListTail.next = copy; // building the clone linkedlist
              cloneListTail = copy; // advance cloneListTail pointer

              // restore curr's next value
              curr.next = tempPtr;
              // advance pointer
              curr = tempPtr;
            }
            return dummyHead.next;
        /*
       // solution 1 using hashmap T:O(n) S:O(n)
        Map<Node, Node> cloneMap = new HashMap<>();
        Node curr = head;
        // first pass
        // populate cloneMap
        // key: current original value
        // value: clone of current
        while(curr != null){
            cloneMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null){
            cloneMap.get(curr).next = cloneMap.get(curr.next);
            cloneMap.get(curr).random = cloneMap.get(curr.random);
            curr = curr.next;
        }
        return cloneMap.get(head);
        */
    }
    
}
