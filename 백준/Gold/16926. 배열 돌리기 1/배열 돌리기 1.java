import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = Math.min(n,m)/2;

        while (r != 0) {
            rotate(count);
            r--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 반시계 방향으로 회전, 테두리를 따라서 회전
    private static void rotate(int count) {
        for (int i = 0; i < count; i++) {
            int temp = map[i][i]; // 기준점 저장

            // left
            for (int j = i; j < m-i-1; j++) {
                map[i][j] = map[i][j+1];
            }

            // up
            for (int j = i; j < n-1-i; j++) {
                map[j][m-1-i] = map[j+1][m-1-i];
            }

            // right
            for (int j = m-1-i; j > i; j--) {
                map[n-1-i][j] = map[n-1-i][j-1];
            }

            // down
            for(int j = n-1-i; j > i; j--) {
                map[j][i] = map[j-1][i];
            }
            
            map[i+1][i] = temp;
        }
    }
}
