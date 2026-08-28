class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] counts = new int[26]; //keeps the frequency of each taskID
        for(char task: tasks){
            counts[task - 'A']++;
        }
        for(int cnt: counts){
            if(cnt > 0){
                maxHeap.add(cnt);
            }
        }
        //cpu time
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();// stores {count, future_timestamp_for_wait}
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if(maxHeap.isEmpty()){ //if maxHeap is fully processed then just fast forward to the time of the taskId that is waiting next
                time = queue.peek()[1];
            }else{ // if maxHeap not empty process the most frequent task
                int cnt = maxHeap.poll() - 1; //decrement the count by 1, that task is processed
                if(cnt > 0){
                    queue.add(new int[]{cnt, time + n}); //add the wait time n from the current ts
                }
            }
            if(!queue.isEmpty() && queue.peek()[1] == time){ //if the next task waiting in the queue has waited its time then pop it and push it to the max heap
                maxHeap.add(queue.poll()[0]);
            }
        }
        return time;
    }
}
