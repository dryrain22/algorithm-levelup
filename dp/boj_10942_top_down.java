package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10942_top_down {
    static int N;
    static int[] num;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N+1];
        dp = new int[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }

        int M = Integer.parseInt(br.readLine());
        int x = 0;
        int y = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            sb.append(DFS(x, y)+"\n");
        }

        System.out.println(sb);
    }

    private static int DFS(int i, int j) {
        // 길이가 1인 경우
        if(i == j) return 1;

        // 길이가 2인 경우
        else if(i+1 == j) {
            if(num[i] == num[j]) return 1;
            else return 0;
        }

        // 탐색 여부 체크(탐색 시, 저장되어있는값 반환)
        if(dp[i][j] != -1) return dp[i][j];

        // 길이가 3이상인 경우
        // 첫 값과 끝 값 무조건 같아야함, 그 사이에 수열도 펠린드롬 이어야함
        if(num[i] != num[j]) {
            return dp[i][j] = 0;
        } else {
            dp[i][j] = DFS(i+1, j-1);
        }

        return dp[i][j];
    }
}
