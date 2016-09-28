class MyQueue {
    private Stack<Integer> stack = new Stack<>();

    
    // Push element x to the back of queue.
    // re-arrange the order of the stack within push()
    public void push(int x) {
        //instack.push(x);
        Stack<Integer> tmp = new Stack<>();
        
        while(!stack.empty()){
          tmp.push(stack.pop());    
        }
        tmp.push(x);
        
        while(!tmp.empty()){
         stack.push(tmp.pop());        
        }
   
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
}