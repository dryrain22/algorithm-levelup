package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2667 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<Node> queue = new LinkedList<>();
    static ArrayList<Integer> result = new ArrayList<>();

    private static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i,j);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int r : result) System.out.println(r);
    }

    private static void bfs(int x, int y) {
        visited[x][y] = true;
        int cnt = 1;
        queue.offer(new Node(x,y,cnt));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int move_x = node.x + dx[i];
                int move_y = node.y + dy[i];

                if(move_x >= 0 && move_x < N && move_y >= 0 && move_y < N) {
                    if(!visited[move_x][move_y] && map[move_x][move_y] == 1) {
                        visited[move_x][move_y] = true;
                        queue.offer(new Node(move_x, move_y, ++cnt));
                    }
                }
            }
        }
        result.add(cnt);
    }
}
