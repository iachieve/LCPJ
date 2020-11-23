class Node{
  Node next, prev;
  int val;
  public Node(int x) { this.val = x;}
}
class MyLinkedList {
    Node head, tail;
    int size;
    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(-1);
        this.tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int idx) {
        if(idx < 0 || idx >= size) return -1;
        Node curr;
        if(idx + 1 < size - idx){
            curr = head;
            for(int i = 0; i < idx + 1; i++) curr = curr.next;
        }else{
            curr = tail;
            for(int i = 0; i < size - idx; i++) curr = curr.prev;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node pred = head, succ = head.next, toAdd = new Node(val);
        toAdd.next = succ;
        toAdd.prev = pred;
        succ.prev = toAdd;
        pred.next = toAdd;
        ++size;
    }
    
    public void addAtTail(int val) {
        Node pred = tail.prev, succ = tail, toAdd = new Node(val);
        
        toAdd.next = succ;
        toAdd.prev = pred;
        succ.prev = toAdd;
        pred.next = toAdd;
            
        ++size;
    }
    
    public void addAtIndex(int idx, int val) {
        if(idx > size) return;
        if(idx < 0) idx = 0;
        Node pred, succ, toAdd = new Node(val);
        if(idx < size - idx){
            pred = head;
            for(int i = 0; i < idx; i++) pred = pred.next;
            succ = pred.next;
        }else{
            succ = tail;
            for(int i = 0; i < size - idx; i++) succ = succ.prev;
            pred = succ.prev;
        }
        
        ++size;
        toAdd.next = succ;
        toAdd.prev = pred;
        succ.prev = toAdd;
        pred.next = toAdd;
    }
    
    public void deleteAtIndex(int idx) {
        if(idx < 0 || idx >= size) return;
        Node pred, succ;
        if(idx < size - idx){
            pred = head;
            for(int i = 0; i < idx; i++) pred = pred.next;
            succ = pred.next.next;
        }else{
            succ = tail;
            for(int i = 0; i < size - idx - 1; i++) succ = succ.prev;
            pred = succ.prev.prev;
        }
        
        --size;
        pred.next = succ;
        succ.prev = pred;
    }
}










































































































