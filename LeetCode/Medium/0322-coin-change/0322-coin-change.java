class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        dp[0] = 0;
        Arrays.sort(coins);

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i < coin) break;

                if (dp[i - coin] != max) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] != max ? dp[amount] : -1;
    }
}