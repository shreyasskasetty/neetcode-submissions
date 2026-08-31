class Solution {
    int[] memo;
    private int solve(int[] cost, int step){
        if(step >= cost.length){
            return 0;
        }
        if(memo[step] != 0){
            return memo[step];
        }
        int minCost = Math.min(solve(cost, step + 1), solve(cost, step + 2));
        memo[step] = cost[step] + minCost;
        return memo[step];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        this.memo = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            this.memo[i] = 0;
        }
        return Math.min(this.solve(cost, 0), this.solve(cost, 1));
    }
}
