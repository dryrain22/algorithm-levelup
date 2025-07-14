package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1520 {
    static int M, N;
    static int[][] graph, dp;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[M][N];
        for(int i = 0; i < M; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(DFS(0, 0));
    }

    private static int DFS(int x, int y) {
        if(x == M-1 && y == N-1) return 1;

        // 전에 방문했다면 저장해둔 dp값 반환
        if(dp[x][y] != -1) return dp[x][y];

        // 방문체크( -1에서 0으로 값 변경)
        dp[x][y] = 0;
        for(int i = 0; i < 4; i++) {
            int move_x = x + dx[i];
            int move_y = y + dy[i];

            if(move_x < 0 || move_x > M-1 || move_y < 0 || move_y > N-1) continue;
            if(graph[x][y] > graph[move_x][move_y]) {
                dp[x][y] += DFS(move_x, move_y);
            }
        }

        return dp[x][y];
    }
}
