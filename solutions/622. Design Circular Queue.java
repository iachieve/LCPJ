class MyCircularQueue {
​
    int[] a;
    int len = 0, front = 0, rear = -1;
    
    public MyCircularQueue(int k) {
        a = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        len++;
         rear = (rear + 1) % a.length;
         a[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        front = (front + 1) % a.length;
        len--;
         return true;
    }
    
    public int Front() { return isEmpty() ? -1 : a[front];}
    
    public int Rear() {return isEmpty() ? -1 : a[rear];}
    
    public boolean isEmpty() { return len == 0; }
    
    public boolean isFull() { return len == a.length; }
}
​
/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
