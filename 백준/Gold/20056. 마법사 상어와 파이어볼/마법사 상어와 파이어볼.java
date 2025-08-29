import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * m : 질량, d : 방향, s : 속력
 * 0 : 위
 * 1 : 우측 윗 대각
 * 2 : 우측
 * 3 : 우측 아랫 대각
 * 4 : 아래
 * 5 : 좌측 아랫 대각
 * 6 : 좌측
 * 7 : 좌측 윗 대각
 *
 */
public class Main {
    static int n,m,k;
    static int[] dr = {-1,-1,0,1,1, 1, 0,-1};
    static int[] dc = { 0, 1,1,1,0,-1,-1,-1};
    static List<Fireball>[][] board;
    static List<Fireball> fireballList = new ArrayList<>();

    static class Fireball {
        int r, c;
        int m, s, d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 격자 크기
        m = Integer.parseInt(st.nextToken()); // 파이어볼 갯수
        k = Integer.parseInt(st.nextToken()); // 상어의 명령횟수

        board = new ArrayList[n+1][n+1]; // (r,c)에 존재하는 파이어볼 리스트 저장을 위한 2차원 배열
        initBoard(); // 보드 초기화

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()); // x
            int c = Integer.parseInt(st.nextToken()); // y
            int m = Integer.parseInt(st.nextToken()); // 질량
            int s = Integer.parseInt(st.nextToken()); // 속도
            int d = Integer.parseInt(st.nextToken()); // 방향

            fireballList.add(new Fireball(r, c, m, s, d));
        }

        while(k > 0) {
            moveFireball();

            for (int i=1; i<=n; i++){
                for (int j=1; j<=n; j++){
                    if (2 <= board[i][j].size()){
                        combineAndDivide(i, j, board[i][j]);
                    }
                }
            }

            // 분배가 완료되었으면 격자에 존재하는 파이어볼 -> List에 추가
            fireballList = new ArrayList<>();
            for (int i=1; i<=n; i++){
                for (int j=1; j<=n; j++){
                    if (!board[i][j].isEmpty()) {
                        fireballList.addAll(board[i][j]);
                    }
                }
            }
            k--;
        }

        System.out.println(fireballList.stream()
                .mapToInt(fireball -> fireball.m)
                .sum()
        );

    }

    private static void initBoard() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = new ArrayList<>();
            }
        }
    }
    
    // 파이어볼 이동 메서드
    private static void moveFireball() {
        initBoard(); // 매번 움직이기 전, 보드 초기화

        for(Fireball fireball : fireballList){
            int moveR = fireball.r + dr[fireball.d]*(fireball.s%n);
            int moveC = fireball.c + dc[fireball.d]*(fireball.s%n);

            if(moveR <= 0) moveR += n;
            if(n < moveR) moveR -= n;
            if(moveC <= 0) moveC += n;
            if(n < moveC) moveC -= n;

            fireball.r = moveR;
            fireball.c = moveC;
            board[fireball.r][fireball.c].add(fireball); // 파이어볼 해당 위치에 저장
        }
    }

    // 파이어볼 합치고 4분할
    private static void combineAndDivide(int r, int c, List<Fireball> fireballs){
        board[r][c] = new ArrayList<>();
        int sumM = 0, sumS = 0;
        boolean isEven = true;
        boolean isOdd = true;

        for(Fireball fireball : fireballs){
            sumM += fireball.m;
            sumS += fireball.s;

            if(fireball.d % 2 == 0) {
                isOdd = false;
            } else {
                isEven = false;
            }
        }

        int nm = sumM/5;
        if(nm<=0) return; // 질량이 0이면 return

        int ns = sumS/fireballs.size();
        int[] dirs = {0, 2, 4, 6};

        if(!isOdd && !isEven){
            dirs[0] = 1; dirs[1] = 3; dirs[2] = 5; dirs[3] = 7;
        }

        // 4분할
        for(int dir : dirs){
            board[r][c].add(new Fireball(r, c, nm, ns, dir));
        }
    }
}
