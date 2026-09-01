class Solution {
    private int solve(String s, int index, Map<Integer, Integer> dp){
        if(dp.containsKey(index)){
            return dp.get(index);
        }
        if(s.charAt(index) == '0') return 0;
        int res = solve(s, index + 1, dp);
        if(index < s.length() - 1){
            if(s.charAt(index) == '1' ||
              (s.charAt(index) == '2' && s.charAt(index + 1) < '7')){
                res += solve(s, index + 2, dp);
            }
        }
        dp.put(index, res);
        return res; 
    }

    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        return solve(s, 0, dp);
    }
}
