class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
       this.pq = new PriorityQueue<>((a, b)->(a-b));
       this.k = k;
       for(int i = 0; i < nums.length; i++){
            pq.offer(nums[i]);
       }
    }
    
    public int add(int val) {
       int res; 
       pq.offer(val);
       
       while(pq.size() > k){
            res = pq.poll();
       }

       return pq.peek();
    }
}
