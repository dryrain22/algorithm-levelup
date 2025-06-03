package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14940 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static int[][] distMap;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // 가로와 세로
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        distMap = new int[N][M];
        visited = new boolean[N][M];

        // 최초 맵 원소 값 -1로 설정
        for (int i = 0; i < N; i++) {
            Arrays.fill(distMap[i], -1);
        }

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) { // 배열의 값이 2라면 이 지점이 시작점!
                    startX = i;
                    startY = j;
                    distMap[i][j] = 0; // 출발좌표는 거리가 0
                }
                // 0인곳은 못가는 곳이니 0으로 세팅
                if(map[i][j] == 0) {
                    distMap[i][j] = 0;
                }
            }
        }

        bfs(startX, startY);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(distMap[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int moveX = node.x + dx[i];
                int moveY = node.y + dy[i];

                if (0 <= moveX && moveX < N && 0 <= moveY && moveY < M) {
                    // 방문하지 않은 좌표라면
                    if(!visited[moveX][moveY] && map[moveX][moveY] == 1) {
                        visited[moveX][moveY] = true;
                        queue.offer(new Node(moveX, moveY));
                        distMap[moveX][moveY] = distMap[node.x][node.y] + 1;
                    }
                }
            }
        }
    }
}
