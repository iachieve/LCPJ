​
class MyCircularQueue {
​
    
    int headIndex, count, capacity, queue[];
    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
        headIndex = 0;
        count = 0;
    }
​
​
    public boolean enQueue(int value) {
        if (count == capacity)
            return false;
        queue[(headIndex + count) % capacity] = value;
        count += 1;
        return true;
    }
​
    public boolean deQueue() {
        if (count == 0)
            return false;
        headIndex = (headIndex + 1) % capacity;
        count -= 1;
        return true;
    }
​
    public int Front() {
        if (count == 0)
            return -1;
        return queue[headIndex];
    }
​
    public int Rear() {
        if (count == 0)
            return -1;
        int tailIndex = (headIndex + count - 1) % capacity;
        return queue[tailIndex];
    }
​
    public boolean isEmpty() {
        return (count == 0);
    }
​
    public boolean isFull() {
        return (count == capacity);
    }
}
​
