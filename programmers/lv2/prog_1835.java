package programmers.lv2;

class Solution_1835 {
    static char[] friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visited = new boolean[8];
    static String[] dt;
    static int answer;
    public int solution(int n, String[] data) {
        dt = data;
        answer = 0;
        backtracking(0, "");

        return answer;
    }

    static void backtracking(int depth, String line) {
        if(!checkLine(line)) return; // backtrcking시 조건 안맞으면 return
        if(depth == 8) {
            // 규칙 체크 후 옳바르게 됐다면 count + 1
            answer++;
            return;
        }

        for(int i = 0; i < 8; i++) {
            // 줄을 안선 프렌즈가 있다면
            if(!visited[i]) {
                visited[i] = true;
                backtracking(depth+1, line + friends[i]);
                visited[i] = false; // DFS로 하위까지 탐색 후에, 다시 현재 depth에서 탐색하기 위함
            }
        }
    }

    static boolean checkLine(String line) {
        if(line.length() < 3) return true;
        for(String d : dt) {
            int dist = d.charAt(4) - '0'; // 조건의 둘 사이 거리
            int idx1 = line.indexOf(d.charAt(0));
            int idx2 = line.indexOf(d.charAt(2));

            if(idx1 == -1 || idx2 == -1) continue; // 조건에 만족하는 문자가 없기에 더 이상 탐색 필요 X
            int realDist = Math.abs(idx1-idx2)-1; // 우리가 줄 세운 실제 둘 사이 거리
            char sign = d.charAt(3);
            switch (sign) {
                case '>':
                    if(realDist <= dist) return false;
                    break;
                case '<':
                    if(realDist >= dist) return false;
                    break;
                case '=':
                    if(realDist != dist) return false;
                    break;
            }
        }

        return true;
    }
}

public class prog_1835 {
    public static void main(String[] args) {
        Solution_1835 solution = new Solution_1835();
        System.out.println(solution.solution(2, new String[]{"N~F=0", "R~T>2"}));
    }
}
