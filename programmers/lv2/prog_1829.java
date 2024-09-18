package programmers.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x;
    int y;
    int cnt;

    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

class Solution_1829 {

    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {
        int maxSizeOfOneArea = 0;
        int numberOfArea = 0;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(m, n, i, j, picture));
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    private int bfs(int m, int n, int x, int y, int[][] picture) {
        visited[x][y] = true;
        int cnt = 1;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, cnt));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int moveX = node.x + dx[i];
                int moveY = node.y + dy[i];

                if (0 <= moveX && moveX < m && 0 <= moveY && moveY < n) {
                    if (!visited[moveX][moveY] && picture[moveX][moveY] == picture[x][y]) {
                        visited[moveX][moveY] = true;
                        queue.offer(new Node(moveX, moveY, ++cnt));
                    }
                }
            }
        }

        return cnt;
    }
}

public class prog_1829 {
    public static void main(String[] args) {
        Solution_1829 solution = new Solution_1829();
        System.out.println(Arrays.toString(solution.solution(6, 4,
                new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1},
                        {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }

}

