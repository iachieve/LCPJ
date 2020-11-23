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









public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

class MyLinkedList {
  int size;
  ListNode head;
  public MyLinkedList() {
    size = 0;
    head = new ListNode(0);
  }

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
    // if index is invalid
    if (index < 0 || index >= size) return -1;

    ListNode curr = head;
    // index steps needed 
    // to move from sentinel node to wanted index
    for(int i = 0; i < index + 1; ++i) curr = curr.next;
    return curr.val;
  }

  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  public void addAtHead(int val) {
    addAtIndex(0, val);
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    addAtIndex(size, val);
  }

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  public void addAtIndex(int index, int val) {
    // If index is greater than the length, 
    // the node will not be inserted.
    if (index > size) return;

    // [so weird] If index is negative, 
    // the node will be inserted at the head of the list.
    if (index < 0) index = 0;

    ++size;
    // find predecessor of the node to be added
    ListNode pred = head;
    for(int i = 0; i < index; ++i) pred = pred.next;

    // node to be added
    ListNode toAdd = new ListNode(val);
    // insertion itself
    toAdd.next = pred.next;
    pred.next = toAdd;
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    // if the index is invalid, do nothing
    if (index < 0 || index >= size) return;

    size--;
    // find predecessor of the node to be deleted
    ListNode pred = head;
    for(int i = 0; i < index; ++i) pred = pred.next;

    // delete pred.next 
    pred.next = pred.next.next;
  }
}
































































































