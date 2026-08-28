class Solution {

    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y) -> Double.compare(
                Math.sqrt(x[0]*x[0] + x[1]*x[1]),
                Math.sqrt(y[0]*y[0] + y[1]*y[1])
            )
        );
        for(int i = 0; i < points.length;i++){
            int xi = points[i][0];
            int yi = points[i][1];
            pq.offer(new int[]{xi, yi});
        }
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }
        return res;
    }
}
