package labg_study;

class Solution_12947 {
    public boolean solution(int x) {
        boolean answer = true;

        String num = String.valueOf(x);
        int sum = 0;

        for(int i = 0; i < num.length(); i++) {
            sum += num.charAt(i) - '0'; // 아스키 코드 값을 10 진수로
        }

        if(x%sum != 0) {
            answer = false;
        }

        return answer;
    }
}

public class pgs_12947 {
    public static void main(String[] args) {
        Solution_12947 solution = new Solution_12947();
        System.out.println(solution.solution(10));
        System.out.println(solution.solution(12));
        System.out.println(solution.solution(11));
        System.out.println(solution.solution(13));
    }
}
