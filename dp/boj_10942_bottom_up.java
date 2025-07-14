package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10942_bottom_up {
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
        }

        // 길이가 1인 경우(무조건 펠린드롬)
        for(int i = 1; i <= N; i++) dp[i][i] = 1;

        // 길이가 2인 경우(두 글자가 같아야 펠린드롬)
        for(int i = 1; i < N; i++) {
            if(num[i] == num[i+1]) dp[i][i+1] = 1;
        }

        // 길이가 3이상 인 경우(첫글자와 끝 글자가 같고, 사이 숫자가 펠린드롬이면)
        for(int len = 2; len < N; len++) {
            for(int start = 1; start + len <= N; start++) {
                int end = start + len;
                if(num[start] == num[end] && dp[start+1][end-1] == 1) dp[start][end] = 1;
            }
        }
        System.out.println(Arrays.deepToString(dp));

        int M = Integer.parseInt(br.readLine());
        int x = 0;
        int y = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            sb.append(dp[x][y]+"\n");
        }

        System.out.println(sb.toString());
    }

}
