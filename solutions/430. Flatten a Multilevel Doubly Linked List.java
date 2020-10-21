/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    
    public Node flatten(Node head) {
        if(head == null) return head;
        Node curr = head;
        //-----------------
        
      while(curr != null){
          if(curr.child != null){
              Node save = curr.next; // nullable
          
              curr.next = flatten(curr.child);
              curr.next.prev = curr;
              curr.child = null;

              while(curr.next != null) curr = curr.next; // get the tail
              curr.next = save; // forgotten
              if(save != null) save.prev = curr;
          }
          
          curr = curr.next;
      }
        
        //-----------------
        return head;
    }

    
 

        
    
    
     public Node flattenIterative(Node head) {
       if(head == null) return head;
        Node curr = head;
        while(curr != null){
            if(curr.child == null){
                curr = curr.next;
                continue;
            }
            Node tail = curr.child;
            while(tail.next != null) tail = tail.next;
           
            tail.next = curr.next;
            if(curr.next != null) curr.next.prev = tail;
            
            curr.next = curr.child;
            curr.child.prev = curr;
            curr.child = null;
            
            curr = curr.next;
        }
        return head;
        
    }
}



        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
