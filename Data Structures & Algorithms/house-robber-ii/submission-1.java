class Solution {
    int[][] memo;
    int n;
    private int solve(int[] nums, int i, int flag){
        if(i >= n || (i == n - 1 && flag == 1)){
            return 0;
        }
        if(memo[i][flag] != -1){
            return memo[i][flag];
        }
        memo[i][flag] = Math.max(solve(nums, i + 1, flag),  nums[i] + solve(nums,i + 2, flag | (i == 0 ? 1 : 0)));
        return memo[i][flag];
    }
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        this.n = nums.length;
        memo = new int[n][2];
        for (int i = 0; i < nums.length; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        return Math.max(this.solve(nums, 0, 1), this.solve(nums, 1, 0));
    }
}
