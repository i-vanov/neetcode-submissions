class MinStack {

    private Stack<Integer> stack;
    // Store the minimum value up to a point in a second stack
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        // Compute the new minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        // Pop from both stack and minStack to keep them aligned
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
    
    public int getMin() {
        // Return the top of minStack, which is the current minimum
        return minStack.peek();
    }
}
