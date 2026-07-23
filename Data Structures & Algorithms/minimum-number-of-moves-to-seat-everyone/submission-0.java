class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        PriorityQueue<Integer> p2 = new PriorityQueue<>();
        for(int i = 0; i < seats.length; i++){
            p1.offer(seats[i]);
            p2.offer(students[i]);
        }
        int res = 0;
        while(!p1.isEmpty()){
            int x = p1.poll();
            int y = p2.poll();
            res += Math.abs(x - y);
        }
        return res;
    }
}