class Tweet{
    private int id;
    private int time;
    public Tweet(int id, int time){
        this.id = id;
        this.time = time;
    }
    public int getTime(){
        return this.time;
    }
    public int getId(){
        return this.id;
    }
}
class Twitter {
    private int time;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        time = 0;
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId, time));
        time--;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)-> Integer.compare(a[0], b[0]));
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        if(followMap.get(userId).size() >= 10){
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
            );
            for(int followeeId: followMap.get(userId)){
                if(tweetMap.containsKey(followeeId)){
                    List<Tweet> tweets = tweetMap.get(followeeId);
                    int index = tweets.size() - 1;
                    Tweet tweet = tweets.get(index);
                    maxHeap.offer(new int[]{-tweet.getTime(), tweet.getId(), followeeId, index - 1});
                }
            }
            
            while(maxHeap.size() > 10){
                maxHeap.poll();
            }
            
            while(!maxHeap.isEmpty()){
                int[] top = maxHeap.poll();
                minHeap.offer(new int[]{-top[0], top[1], top[2], top[3]});
            }
        }else{
            for(int followeeId: followMap.get(userId)){
                if(tweetMap.containsKey(followeeId)){
                    List<Tweet> tweets = tweetMap.get(followeeId);
                    int index = tweets.size() - 1;
                    Tweet tweet = tweets.get(index);
                    minHeap.offer(new int[]{tweet.getTime(), tweet.getId(), followeeId, index - 1});
                }
            }
        }
        while(!minHeap.isEmpty() && res.size() < 10){
            int[] top = minHeap.poll();
            res.add(top[1]);
            int nextIndex = top[3];
            if(nextIndex >= 0){
                List<Tweet> tweets = tweetMap.get(top[2]);
                Tweet nextTweet = tweets.get(nextIndex);
                minHeap.offer(new int[]{nextTweet.getTime(), nextTweet.getId(), top[2], nextIndex - 1});
            }
        }
       return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId!=followeeId){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
