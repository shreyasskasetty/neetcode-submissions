class Solution {
    int[] memo;
    private int solve(int steps, int n){
        if(steps == n){
            return 1;
        }
        if(steps > n){
            return 0;
        }
        if(memo[steps] != -1){
            return memo[steps];
        }
        memo[steps] = solve(steps + 1, n) + solve(steps + 2, n);
        return memo[steps];
    }
    public int climbStairs(int n) {
        this.memo = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            memo[i] = -1;
        }
        return this.solve(0, n);
    }
}
