class Solution {
    public int longestPalindrome(String s) {
        int[] alphabet = new int[52];
        boolean flag = false;
       if (s.length() == 1) return 1;

        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLower(c)) {
                alphabet[s.charAt(i) - 'a']++;
            } else {
                alphabet[s.charAt(i) - 'A' + 26]++;
            }
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] % 2 == 0) answer += alphabet[i];
            if (alphabet[i] % 2 != 0 && alphabet[i] != 1) answer += alphabet[i]-1;
            if (alphabet[i] % 2 != 0) flag = true;
        }

        if (flag) answer++;
        return answer;
    }

    private boolean isLower(char c) {
        if (c >= 'a' && c <= 'z') return true;
        return false;
    }
}