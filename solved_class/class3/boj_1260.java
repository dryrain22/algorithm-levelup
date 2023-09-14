package solved_class.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260 {
    static int n;
    static int m;
    static int v;
    static int node1;
    static int node2;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }

        DFS(v);
        System.out.println();
        visited = new boolean[n+1];
        BFS(v);
    }

    static void DFS(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for(int i = 1; i <= n; i++) {
            if(graph[start][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        System.out.print(start + " ");

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int i = 1; i <= n; i++) {
                if(i != node && graph[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

}
