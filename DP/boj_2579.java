package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 한번에 한 계단 | 두 계단
 * 연속된 세계단은 X
 * 마지막 계단은 필수
 * 최대값 출력
 **/
public class boj_2579 {
    static int[] steps;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        steps = new int[N+1];
        dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = steps[1];
        if (N >= 2) {
            dp[2] = steps[1] + steps[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + steps[i - 1]) + steps[i];
        }

        System.out.println(dp[N]);
    }
}
