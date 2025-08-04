package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_21736 {
    private static int N, M;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static String[][] campus;
    private static boolean[][] visited;
    private static Queue<Node> queue = new LinkedList<>();

    static class Node {
        int x;
        int y;

        private Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new String[N][M];
        visited = new boolean[N][M];

        int doyeonX = 0;
        int doyeonY = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                String info = String.valueOf(str.charAt(j));
                campus[i][j] = info;

                if (info.equals("I")) {
                    doyeonX = i;
                    doyeonY = j;
                }
            }
        }

        int answer = bfs(doyeonX, doyeonY);
        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }

    private static int bfs(int x, int y) {
        int answer = 0;

        visited[x][y] = true; // 방문체크
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int moveX = node.x + dx[i];
                int moveY = node.y + dy[i];

                // 방문한 곳이 아니라면
                if (0 <= moveX && moveX < N
                        && 0 <= moveY && moveY < M && !visited[moveX][moveY]) {
                    // 벽이 아니라면, 탐색할 곳으로 추가
                    if (!campus[moveX][moveY].equals("X")) {
                        queue.add(new Node(moveX, moveY));
                    }

                    if (isPeople(moveX, moveY)) {
                        answer++;
                    }
                    visited[moveX][moveY] = true; // 방문처리
                }
            }
        }

        return answer;
    }

    private static boolean isPeople(int x, int y) {
        return campus[x][y].equals("P");
    }

}
