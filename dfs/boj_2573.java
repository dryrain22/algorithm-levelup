package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2573 {
    static int n,m;
    static int[][] graph, melt;
    static boolean[][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        melt = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        // 두 덩어리 이상 분리될 때까지 덩어리 탐색 + melting 작업(1년씩)
        while(true) {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(!visited[i][j] && graph[i][j] != 0) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            if(cnt == 0) {
                System.out.println(0);
                break;
            } else if(cnt >= 2) {
                System.out.println(year);
                break;
            }

            melting();
            year++;
        }

    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int move_x = x + dx[i];
            int move_y = y + dy[i];

            if(move_x >= 0 && move_x <= n && move_y >= 0 && move_y <= m) {
                // 상하좌우 판단하여 1년에 녹는 빙하 높이 계산
                if(graph[move_x][move_y] == 0) {
                    melt[x][y]++;
                }
                if(!visited[move_x][move_y] && graph[move_x][move_y] != 0) {
                    dfs(move_x, move_y);
                }
            }
        }
    }

    static void melting() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                graph[i][j] -= melt[i][j];
                if(graph[i][j] < 0) {
                    graph[i][j] = 0;
                }
            }
        }
        melt = new int[n][m];
        visited = new boolean[n][m];
    }
}
