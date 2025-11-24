class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int numLength = nums.length; 
        int answer = 0;
        Arrays.sort(nums);

        // -4, -1, 1, 2
        for (int i = 0; i < numLength - 1; i++) {
            int left = i + 1;
            int right = numLength - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (numLength == 3) return sum;

                int diff = Math.abs(sum-target);
                if (diff <= closest) {
                    closest = diff;    //1
                    answer = sum; // 2
                } 

                if (target <= sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return answer;
    }
}