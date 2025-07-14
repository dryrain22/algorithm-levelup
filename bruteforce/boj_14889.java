package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14889 {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int choiceCnt;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // N은 짝수
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        StringTokenizer st;

        choiceCnt = N/2; // N/2개 만큼 팀을 초이스해야함

        // 두 팀의 능력치 차이의 최소값을 구하라!
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0);
        System.out.println(min);
    }

    private static void dfs(int idx, int cnt) {
        if (cnt == choiceCnt) {
            // 점수차 계산 로직 구현
            min = Math.min(min, getScore());
            return;
        }

        for (int i = idx; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, cnt+1);
                visited[i] = false;
            }
        }
    }

    private static int getScore() {
        // 팀 구성원을 담을 배열
        int[] start = new int[N/2];
        int[] link = new int[N/2];

        int startIdx = 0;
        int linkIdx = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                start[startIdx++] = i;
            } else {
                link[linkIdx++] = i;
            }
        }

        int startScore = 0;
        int linkScore = 0;
        for (int i = 0; i < N/2; i++) {
            for (int j = i+1; j < N/2; j++) {
                startScore += map[start[i]][start[j]] + map[start[j]][start[i]];
                linkScore += map[link[i]][link[j]] + map[link[j]][link[i]];
            }
        }

        return Math.abs(startScore - linkScore);
    }
}
