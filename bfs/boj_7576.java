package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj_7576 {

    static int M,N;
    static int[][] map;
    static Queue<Node> queue = new LinkedList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    private static class Node {
        int x;
        int y;
        int day;

        public Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    queue.offer(new Node(i, j, 0));
                }
            }
        }
        bfs();
    }

    private static void bfs() {
        int day = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            day = node.day;

            for(int i = 0; i < 4; i++) {
                int move_x = node.x + dx[i];
                int move_y = node.y + dy[i];

                if(move_x >= 0 && move_x < N && move_y >= 0 && move_y < M) {
                    if(map[move_x][move_y] == 0) {
                        map[move_x][move_y] = 1;
                        queue.offer(new Node(move_x, move_y, day+1));
                    }
                }
            }
        }
        System.out.println(checkTomato() ? day : -1);
    }

    private static boolean checkTomato() {

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }
}
