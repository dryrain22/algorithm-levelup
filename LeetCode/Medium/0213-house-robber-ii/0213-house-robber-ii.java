class Solution {
    public int rob(int[] nums) {
        int house = nums.length;
        int[] dp1 = new int[house+1]; // 0 to n-1
        int[] dp2 = new int[house+1]; // 1 to n
        
        if (house == 1) return nums[0];
        dp1[1] = nums[0];
        dp2[2] = nums[1];

        for (int i = 2; i <= house; i++) {
            if (i < house) {
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i-1]);
            }

            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i-1]);
        }

        return Math.max(dp1[house-1], dp2[house]);
    }
}