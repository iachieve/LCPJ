class MyQueue {
​
    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();
    
    public void push(int x) { pushStack.push(x); }
    
    public int pop() {
        emptyPushStack();
        if(!popStack.isEmpty()) return popStack.pop();
        return -1;
    }
    
    public int peek() {
        emptyPushStack();
        if(!popStack.isEmpty()) return popStack.peek();
        return -1;
    }
    
    public boolean empty() { return pushStack.isEmpty() && popStack.isEmpty(); }
    
    private void emptyPushStack(){
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
    }
    
}
​
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
