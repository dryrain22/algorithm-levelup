class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        dp[1] = costs[0] + 1;

        for (int i = 2; i <= n; i++) {
            if (i == 2) {
                dp[i] = (int)Math.min(costs[i-1] + 4, dp[i-1] + costs[i-1] + 1);
            } else {
                dp[i] = Math.min(Math.min(dp[i-3] + costs[i-1] + 9, dp[i-2] + costs[i-1] + 4), dp[i-1] + costs[i-1] + 1);
            }          
        }
        return dp[n];
    }
}