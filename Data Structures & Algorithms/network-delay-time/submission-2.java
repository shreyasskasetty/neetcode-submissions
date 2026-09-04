class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int[] time: times){
            adj.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]}); // u -> {v, w}
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k});
        int t = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int w1 = curr[0];
            int n1 = curr[1];
            if(visited.contains(n1)){
                continue;
            }
            visited.add(n1);
            t = w1;
            if(adj.containsKey(n1)){
                for(int[] neigh: adj.get(n1)){
                    int w2 = neigh[1];
                    int n2 = neigh[0];
                    if(!visited.contains(n2)){
                        pq.offer(new int[]{w1 + w2, n2});
                    }
                }
            }  
        }
        return visited.size() == n?t:-1;
    }
}
