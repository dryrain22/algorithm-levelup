package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1743 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n,m,k, cnt;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        int r = 0;
        int c = 0;
        int ans = 0;

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[r][c] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    cnt = 0;
                    DFS(i, j);
                    ans = Math.max(cnt, ans);
                }
            }
        }
        System.out.println(ans);
    }

    static void DFS(int x, int y) {
        cnt++;
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];
            if(new_x < 1 || new_x >= n+1 || new_y <1 || new_y >= m+1 || visited[new_x][new_y] || graph[new_x][new_y] == 0) continue;
            DFS(new_x, new_y);
        }
    }
}
