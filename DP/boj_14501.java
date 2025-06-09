package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][2];
        int[] dp = new int[N+2];

        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int day = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            arr[i][0] = day;
            arr[i][1] = pay;
        }

        for (int i = 1; i <= N; i++) {
            dp[i+1] = Math.max(dp[i+1], dp[i]);

            // i일에 상담을 시작할 수 있으면, 끝나는 날에 금액 +
            int finishDay = i + arr[i][0];
            if (finishDay <= N+1) {
                dp[finishDay] = Math.max(dp[finishDay], dp[i] + arr[i][1]);
            }
        }

        System.out.println(dp[N+1]);
    }
}
