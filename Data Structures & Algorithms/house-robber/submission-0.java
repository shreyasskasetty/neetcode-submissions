class Solution {
    int[] memo;
    int n;
    private int solve(int[] nums, int index){
        if(index >= this.n){
            return 0;
        }
        if(memo[index] != -1){
            return memo[index];
        }
        memo[index] = Math.max(nums[index] + solve(nums, index + 2), solve(nums,index + 1));
        return memo[index];
    }

    public int rob(int[] nums) {
        this.memo = new int[nums.length + 1];
        for(int i = 0; i < nums.length + 1; i++){
            memo[i] = -1;
        }
        this.n = nums.length;
        return solve(nums, 0);
    }
}
