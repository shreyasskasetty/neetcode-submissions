class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;
        for(int i = 0; i < n - 1; i++){
            for(int[] time: times){
                int u = time[0] - 1;
                int v = time[1] - 1;
                int w = time[2];
                 if(dist[u] + w < dist[v] && dist[u] != Integer.MAX_VALUE){
                    dist[v] = dist[u] + w;
                }
            }
        }
        int res = 0;
        for(int d: dist){
            res = Math.max(res, d);
        }
        return res == Integer.MAX_VALUE?-1:res;
    }
}
