class Solution {
    public int jump(int[] nums) {
        int lastIndex = nums.length-1;
        int currMaxJump = 0;
        int nextMaxJump = 0;
        int answer = 0;

        for (int i = 0; i < lastIndex; i++) {
            nextMaxJump = Math.max(nextMaxJump, nums[i] + i);
            
            if (i == currMaxJump) {
                answer++;
                currMaxJump = nextMaxJump;
            }
        }

        return answer;
    }
}