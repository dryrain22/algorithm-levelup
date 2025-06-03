package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14502 {
    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N;
    private static int M;
    private static int[][] map;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static long answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int safe = 0;
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) {
                    safe++;
                }
            }
        }

        backTracking(0);
        System.out.println(safe-answer-3);
    }

    private static void backTracking(int cnt) {
        if(cnt == 3) { // 벽을 3개 세우면, 바이러스 감염 시작 시키고 갯수 카운팅
            answer = Math.min(answer, bfs()); //
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1; // 현재 칸에 벽 세우고
                    backTracking(cnt+1); // 백트래킹 탐색
                    map[i][j] = 0; // 백트래킹
                }
            }
        }
    }

    private static long bfs() {
        int cnt = 0;
        boolean[][] visited = new boolean[N][M];
        Queue<Virus> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 2) {
                    visited[i][j] = true;
                    queue.offer(new Virus(i,j)); // 바이러스 감염된 곳 좌표 Queue에 삽입
                }
            }
        }

        while(!queue.isEmpty()) {
            Virus virus = queue.poll();

            // 바이러스 최초 감염된 곳을 기점으로 가로 세로 범위 감염진행
            for (int i = 0; i < 4; i++) {
                int moveX = virus.x + dx[i];
                int moveY = virus.y + dy[i];

                if (0 <= moveX && moveX < N && 0 <= moveY && moveY < M
                        && !visited[moveX][moveY] && map[moveX][moveY] == 0) {
                    visited[moveX][moveY] = true;
                    cnt++;
                    queue.offer(new Virus(moveX, moveY));
                }
            }
        }
        return cnt;
    }
}
