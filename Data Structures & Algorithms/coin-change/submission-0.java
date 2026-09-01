class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    private int solve(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        if(memo.containsKey(amount)){
            return memo.get(amount);
        }
        int res = Integer.MAX_VALUE;
        for(int coin: coins){
            if(amount - coin >=0){
                int result = solve(coins, amount - coin);
                if(result != Integer.MAX_VALUE){
                    res = Math.min(res, 1 + result);
                }
            }
        }
        memo.put(amount, res);
        return res;
    }
    public int coinChange(int[] coins, int amount) {
        int minCoins = solve(coins, amount);
        return minCoins == Integer.MAX_VALUE?-1:minCoins;
    }
}
