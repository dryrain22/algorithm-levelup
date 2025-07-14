package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2458 {
    static int n, m, a, b;
    static int[][] adj, r_adj;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new int[n+1][n+1];
        r_adj = new int[n+1][n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a][b] = r_adj[b][a] = 1;
        }

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            cnt = 0;
            DFS(i, adj, new boolean[n+1]); // 자신보다 큰 숫자 확인
            DFS(i, r_adj, new boolean[n+1]); // 자신보다 큰 숫자 확인

            if(cnt == n-1) ans++;
        }
        System.out.println(ans);
    }

    static void DFS(int idx, int[][] arr, boolean[] visited) {
        visited[idx] = true;
        for(int i = 1; i <= n; i++) {
            if(!visited[i] && arr[idx][i] == 1) {
                cnt++;
                DFS(i, arr, visited);
            }
        }
    }
}
