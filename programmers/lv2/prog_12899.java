package programmers.lv2;

class Solution_12899 {
    public String solution(int n) {
        String[] arr = {"4", "1", "2"}; // 이 배열의 인덱스 = 나머지 값
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            int index = n % 3;
            n /= 3;

            if(index == 0) {
                n--;
            }
            sb.insert(0, arr[index]);
        }

        return sb.toString();
    }
}


public class prog_12899 {
    public static void main(String[] args) {
        Solution_12899 solution = new Solution_12899();
        System.out.println(solution.solution(500));
    }
}
