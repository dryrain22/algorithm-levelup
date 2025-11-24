class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int left = 0; 
        int right = height.length-1;
        
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int width = right - left;

            answer = Math.max(answer, width * Math.min(leftHeight, rightHeight));
            if (leftHeight <= rightHeight) left++;
            else right--;
        }

        return answer;
    }
}