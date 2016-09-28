class MinStack {
    public LinkedList<Integer> unsorted = new LinkedList<>();
    public LinkedList<Integer> min = new LinkedList<>();
    
    public void push(int x) {
       unsorted.add(x);
       if (min.size() == 0) {
          min.add(x); 
       } else {
         Integer last = min.peekLast();
         if (last > x) {
            min.add(x); 
         } else {
            min.add(last);     
         }
       }
    }

    public void pop() {
      unsorted.removeLast(); 
      min.removeLast();
    }

    public int top() {
      return unsorted.peekLast();        
    }

    public int getMin() {
      return min.peekLast();   
    }
    
}