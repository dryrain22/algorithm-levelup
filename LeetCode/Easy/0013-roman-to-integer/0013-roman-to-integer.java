class Solution {
    public int romanToInt(String s) {
        int answer = 0;
    
        for (int i = 0; i < s.length(); i++) {
            int current = convertNum(s.charAt(i));
            int next = (i + 1 < s.length()) ? convertNum(s.charAt(i + 1)) : 0;

            if (current < next) {
                answer -= current;
            } else {
                answer += current;
            }
        }
        return answer;
    }

    private int convertNum(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}