package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1051 {
    private static int N;
    private static int M;
    private static int[][] rectangleArr;
    private static int cnt = 0;
    private static int maxSize = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        rectangleArr = new int[N][M];


        // 직사각형의 사이즈가 1이 아닌 경우에는 배열에 값 대입
        for (int i = 0; i < N; i++) {
            if (N == 1) {
                System.out.println(1);
                System.exit(0); // 시스템종료
            }

            String num = br.readLine();
            for (int j = 0; j < M; j++) {
                rectangleArr[i][j] = num.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 정사각형인지 체크하고 만약 정사각형이라면 해당 포인트에서 maxSize 구하기
                cnt = 0;
                checkSquare(rectangleArr[i][j], i, j, 0);
                maxSize = Math.max(maxSize, cnt);
            }
        }

        System.out.println(maxSize);
    }

    // 정사각형인지 체크(끝 모서리 포인트를 재귀 탐색으로 maxsize 체크)
    private static void checkSquare(int num, int x, int y, int depth) {
        // 최초 실행 시엔 바로 재귀탐색
        if(depth == 0) {
            checkSquare(num, x+1, y+1, 1);
        }

        // 범위 밖으로 벗어나면 return
        if ((x+depth) >= N || (y+depth) >= M) {
            return;
        }

        // 같은 값인지 체크
        if (num == rectangleArr[x+depth][y] && num == rectangleArr[x][y+depth] && num == rectangleArr[x+depth][y+depth]) {
            cnt = (int) Math.pow(depth+1, 2);
        }

        checkSquare(num, x, y, depth+1);
    }

}
