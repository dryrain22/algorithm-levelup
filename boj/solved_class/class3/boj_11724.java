package solved_class.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11724 {
    static int N;
    static int M;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1][node2] = graph[node2][node1] = 1;
        }

        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                DFS(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void DFS(int node) {
        visited[node] = true;
        for(int i = 1; i <= N; i++) {
            if(graph[node][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }
}
