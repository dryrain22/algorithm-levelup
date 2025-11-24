class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while(right < s.length()) {
            char c = s.charAt(right);

            if(!set.contains(c)) {
                set.add(c);
                right++; // 윈도우 증가
                max = Math.max(max, set.size());
            } else {
                // 윈도우 감소
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}