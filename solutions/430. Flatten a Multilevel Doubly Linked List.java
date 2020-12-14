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

    
 
class Solution {    // 5
    public Node flatten(Node head) {
        if (head == null) return head;
        Node prev = new Node(0, null, head, null), cur;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            prev.next = cur;
            cur.prev = prev;
            if (cur.next != null) stack.push(cur.next);
            if (cur.child != null) stack.push(cur.child);
            cur.child = null;
            prev = cur;
        }
        head.prev = null;
        return head;
    }
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

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        dfs(new Node(0, null, head, null), head);
        head.prev = null;
        return head;
    }
    public Node dfs(Node prev, Node cur) {
        if (cur == null) return prev;
        cur.prev = prev;
        prev.next = cur;
        
        Node temp = cur.next;
        Node tail = dfs(cur, cur.child); // left subtree
        cur.child = null;
        return dfs(tail, temp); // flatten right sub tree
    }
}

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
