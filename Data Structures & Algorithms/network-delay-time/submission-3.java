class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> adjList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        //construct adjacency matrix u -> {v, w}
        for(int i = 0; i < times.length; i++){
            adjList.computeIfAbsent(times[i][0], x -> new ArrayList<>()).add(new int[]{times[i][1], times[i][2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0, k}); // {weight, node}. Start with node k with 0 distance to it 
        int res = 0;
        while(!pq.isEmpty()){
            int[] item = pq.poll();
            int w1 = item[0];
            int n1 = item[1];
            if(visited.contains(n1)){
                continue;
            }
            res = w1;
            visited.add(n1);
            if(adjList.containsKey(n1)){
                for(int[] neigh: adjList.get(n1)){
                    int n2 = neigh[0];
                    int w2 = neigh[1];
                    if(!visited.contains(n2)){
                        pq.offer(new int[]{w1 + w2, n2});
                    }
                }
            }
        }
        return visited.size() == n?res:-1;
    }
}
