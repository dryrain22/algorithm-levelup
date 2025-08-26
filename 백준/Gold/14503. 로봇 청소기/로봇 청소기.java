import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x;
        int y;
        int dir;

        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static int n,m;
    static int[][] rooms;
    static boolean[][] isCleaned;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        rooms = new int[n][m];
        isCleaned = new boolean[n][m]; // 청소 여부
        
        st = new StringTokenizer(br.readLine(), " ");
        int firstX = Integer.parseInt(st.nextToken());
        int firstY = Integer.parseInt(st.nextToken());
        int firstDir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(clean(firstX, firstY, firstDir)); // 시작위치부터 출발!
    }

    /**
     * direction 변수 설명
     * 0 : 북, 1 : 동, 2 : 남, 3 : 서
     */
    private static int clean(int x, int y, int dir) {
        int cleanCnt = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, dir));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;
            int nowDir = node.dir;

            // 현재 칸 청소
            if (!isCleaned[nowX][nowY] && rooms[nowX][nowY] == 0) {
                isCleaned[nowX][nowY] = true;
                cleanCnt++;
            }

            // 현재 칸에서 주변 4칸 탐색
            boolean isMoved = false;
            int moveDir = nowDir;
            for (int i = 0; i < 4; i++) {
                // 반시계 방향 90도 회전
                moveDir = (moveDir + 3) % 4;
                int moveX = nowX + dx[moveDir];
                int moveY = nowY + dy[moveDir];

                // 주변 4칸 중 청소되지 않은 빈칸 있는 경우
                if (0 <= moveX && moveX < n && 0 <= moveY && moveY < m) {
                    // 청소되지 않았다면, 전진
                    if (!isCleaned[moveX][moveY] && rooms[moveX][moveY] == 0) {
                        queue.add(new Node(moveX, moveY, moveDir));
                        isMoved = true;
                        break;
                    }
                }
            }

            if (isMoved) continue;

            // 주변 4칸 중 빈 칸이 없는 경우
            // 후진이 가능하다면
            int backDir = (nowDir + 2) % 4;
            int backX = nowX + dx[backDir];
            int backY = nowY + dy[backDir];

            if (backX < 0 || backX >= n || backY < 0 || backY >= m || rooms[backX][backY] == 1) {
                break;
            } else {
                // 현재방향은 유지
                queue.add(new Node(backX, backY, nowDir));
            }
        }

        return cleanCnt;
    }
}
