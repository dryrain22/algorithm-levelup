class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[start] != nums[i]) {
                start++;
                nums[start] = nums[i];
            }
        }

        return start+1;
    }
}