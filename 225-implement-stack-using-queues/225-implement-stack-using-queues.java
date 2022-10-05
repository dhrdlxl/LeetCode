class MyStack {
    private Queue<Integer>[] queue;
    private int type;
    public MyStack() {
        queue = new LinkedList[2];
        for (int i = 0; i < 2; i ++) {
            queue[i] = new LinkedList<Integer>();
        }
        
        type = 0;
    }
    
    public void push(int x) {
        queue[type].offer(x);
    }
    
    public int pop() {
        int otherType = (1 ^ type);
        
        while(queue[type].size() > 1) {
            queue[otherType].offer(queue[type].poll());
        }
        
        int popElement = queue[type].poll();
        type = otherType;
        return popElement;
    }
    
    public int top() {
        int otherType = (1 ^ type);
        
        while(queue[type].size() > 1) {
            queue[otherType].offer(queue[type].poll());
        }
        
        int top = queue[type].peek();
        queue[otherType].offer(queue[type].poll());
        type = otherType;
        return top;
    }
    
    public boolean empty() {
        return queue[type].isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */