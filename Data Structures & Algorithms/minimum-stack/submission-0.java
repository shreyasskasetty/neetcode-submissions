class MinStack {
    Stack<List<Integer>> minStk;
    public MinStack() {
        this.minStk = new Stack();
    }
    
    public void push(int val) {
        int minVal = 20000;
        if(minStk.isEmpty()){
            this.minStk.push(Arrays.asList(val, val));
        }else{
            if(minStk.peek().get(1) < val){
                this.minStk.push(Arrays.asList(val, minStk.peek().get(1)));
            }else{
                this.minStk.push(Arrays.asList(val, val));
            }  
        }
    }
    
    public void pop() {
        if(!minStk.isEmpty()){
            List<Integer> item = minStk.pop();
        }
    }
    
    public int top() {
        if(!minStk.isEmpty()){
            return minStk.peek().get(0);
        }
        return -1;
    }
    
    public int getMin() {
        if(!minStk.isEmpty())
            return minStk.peek().get(1);
        return -1;
    }
}
