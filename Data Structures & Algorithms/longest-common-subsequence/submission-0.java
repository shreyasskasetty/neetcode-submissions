class Solution {
    private int lcs(int i, int j, String text1, String text2, int[][] dp){
        if(i == text1.length()|| j == text2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = lcs(i + 1, j + 1, text1, text2, dp) + 1;
        } else {
            dp[i][j] = Math.max(
                lcs(i + 1, j, text1, text2, dp),
                lcs(i, j + 1, text1, text2, dp)
            );
        }
        return dp[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lcs(0, 0, text1, text2, dp);
    }
}
