package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10026 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static String[][] graph;
    static boolean[][] visited;
    static int cnt = 0;
    static int cnt2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new String[n][n];
        visited = new boolean[n][n];
        String color;

        for(int i = 0; i < n; i++) {
            color = br.readLine();
            for(int j = 0; j < n; j++) {
                graph[i][j] = String.valueOf(color.charAt(j));
            }
        }

        // 일반인 검사 진행
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    find_same_color(i, j);
                    cnt++;
                }
            }
        }

        // 적록색약인 검사 진행
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    find_same_color(i, j);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt + " " + cnt2);
    }

    static void find_same_color(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int move_x = dx[i] + x;
            int move_y = dy[i] + y;

            if(move_x >= 0 && move_x < n && move_y >= 0 && move_y < n && !visited[move_x][move_y]) {
                if(graph[x][y].equals(graph[move_x][move_y])) {
                    find_same_color(move_x, move_y);
                }
            }
        }

        // 방문한 곳의 R색은 G색으로 변경해주기(추후의 적록색약 검사 진행을 위해)
        if(graph[x][y].equals("R")) graph[x][y] = "G";
    }

}
