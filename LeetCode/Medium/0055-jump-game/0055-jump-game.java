class Solution {
    public boolean canJump(int[] nums) {
        int maxIndexJump = 0;

        for (int i = 0; i < nums.length; i++) {
            if (maxIndexJump < i) return false;

            maxIndexJump = Math.max(maxIndexJump, nums[i] + i);
        }

        return true;
    }
}