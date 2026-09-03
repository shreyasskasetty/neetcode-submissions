class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][1]] += 1;
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            courses[numCourses - count - 1]=course;
            count++;
            for(int neigh: adj.get(course)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    queue.offer(neigh);
                }
            }
        }
        if(count != numCourses){
            return new int[0];
        }
        return courses;
    }
}
