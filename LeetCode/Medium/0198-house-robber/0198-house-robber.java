class Solution {
    public int rob(int[] nums) {
        int house = nums.length;
        int[] dp = new int[house+1];
        dp[1] = nums[0];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= house; i++) {
            if (i == 2) {
                dp[i] = nums[i-1];
            }
            
            for (int j = i+2; j <= house; j++) {
                dp[j] = Math.max(dp[j], dp[i] + nums[j-1]);    
            }
        }
        
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}