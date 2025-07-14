package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1025 {
    static int N, M;
    static int[][] table;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        table = new int[N][M];

        for (int i = 0; i < N; i++) {
            String num = br.readLine();
            for (int j = 0; j < M; j++) {
                table[i][j] = num.charAt(j) - '0';
            }
        }

        /**
         * dx = 열에 대한 공차( -N < dx < N )
         * dy = 행에 대한 공차( -M < dy < M )
         */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                getMaxSquareNum(i, j);
            }
        }

        System.out.println(max);
    }

    private static void getMaxSquareNum(int x, int y) {
        for (int dx = -N; dx < N; dx++) {
            for (int dy = -M; dy < M; dy++) {
                if ( dx == 0 && dy == 0 ) {
                    continue;
                }
                int num = 0;
                int moveX = x;
                int moveY = y;

                while (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M) {
                    num = 10 * num + table[moveX][moveY];

                    if (isSquareNum(num)) {
                        max = Math.max(max, num);
                    }

                    moveX += dx;
                    moveY += dy;
                }
            }
        }
    }

    private static boolean isSquareNum(int num) {
        return (int) Math.sqrt(num) == Math.sqrt(num);
    }
}
