// solution # 1 using one stack
​
// solution # 2 using two stacks
​
class MinStack {
    Stack<Integer> stk = new Stack<>();;
    Stack<Integer> h= new Stack<>();
​
    public void push(int x) {
        stk.push(x);
        if(h.isEmpty() || x <= h.peek()) h.push(x);
    }
    
    public void pop() {
        int x = stk.pop();
        if(x == h.peek()) h.pop();
    }
    public int top() { return stk.peek(); }
    public int getMin() { return h.peek(); }
}
​
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
