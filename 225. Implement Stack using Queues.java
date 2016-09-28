class MyStack {
    // Push element x onto stack.
    private Queue<Integer> queue = new LinkedList<>();
    
    public void push(int x) {
        queue.add(x);
    }

    /* Please refer for following method
     * https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html
     */
    // Removes the element on top of the stack.
    public void pop() {
        for(int i=0; i<queue.size()-1;i++) {
           queue.add(queue.remove());
        }
        queue.remove();
    }

    // Get the top element.
    public int top() {
        int result = 0;
        
        for(int i=0; i<queue.size();i++) {
           if(i==queue.size()-1) {
             result = queue.peek();  
           }
           queue.add(queue.remove());
        }
        
        return result;   
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}